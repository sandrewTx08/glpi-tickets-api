package com.sandrewtx08.glpi_tickets.service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Service;

import com.sandrewtx08.glpi_tickets.dto.TicketSolveEstimation;
import com.sandrewtx08.glpi_tickets.model.GlpiTickets;

@Service
public class TicketSolveService {
    private static final int MILHOUR = 1000 * 60 * 60;

    public TicketSolveEstimation estimateTicketSolveTime(List<GlpiTickets> tickets) {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        tickets.forEach(ticket -> {
            if (ticket.getDateCreation() != null && ticket.getSolvedate() != null) {
                double resolutionTime = Duration
                        .between(ticket.getDateCreation(), ticket.getSolvedate())
                        .toMillis() / MILHOUR;
                stats.addValue(resolutionTime);
            }
        });

        TicketSolveEstimation estimation = new TicketSolveEstimation();

        estimation.setMean(getClosestTicketToValue(tickets, stats.getMean()));
        estimation.setMedian(getClosestTicketToValue(tickets, stats.getPercentile(50)));
        estimation.setMin(getTicketForTime(tickets, stats.getMin()));
        estimation.setMax(getTicketForTime(tickets, stats.getMax()));
        estimation.setTotalTickets(tickets.size());

        return estimation;
    }

    private GlpiTickets getClosestTicketToValue(List<GlpiTickets> tickets, double value) {
        return tickets.stream()
                .min(Comparator.comparingDouble(ticket -> Math.abs(getResolutionTime(ticket) - value)))
                .orElse(null);
    }

    private double getResolutionTime(GlpiTickets ticket) {
        if (ticket.getDateCreation() == null || ticket.getSolvedate() == null) {
            return 0;
        }

        return Duration
                .between(ticket.getDateCreation(), ticket.getSolvedate())
                .toMillis() / MILHOUR;
    }

    private GlpiTickets getTicketForTime(List<GlpiTickets> tickets, double time) {
        return tickets.stream()
                .filter(ticket -> getResolutionTime(ticket) == time)
                .findFirst()
                .orElse(null);
    }
}
