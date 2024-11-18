package com.sandrewtx08.glpi_tickets.service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.stereotype.Service;

import com.sandrewtx08.glpi_tickets.dto.TicketSolveEstimation;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsContent;

@Service
public class TicketSolveService {

    public TicketSolveEstimation estimateTicketSolveTime(List<GlpiTicketsContent> tickets) {
        DescriptiveStatistics stats = new DescriptiveStatistics();

        tickets.forEach(ticket -> {
            double resolutionTime = Duration
                    .between(ticket.getDateCreation(), ticket.getSolvedate())
                    .toMillis() / (1000 * 60 * 60);
            stats.addValue(resolutionTime);
        });

        TicketSolveEstimation estimation = new TicketSolveEstimation();

        estimation.setMean(getClosestTicketToValue(tickets, stats.getMean()));
        estimation.setStdDev(getClosestTicketToValue(tickets, stats.getStandardDeviation()));
        estimation.setMedian(getClosestTicketToValue(tickets, stats.getPercentile(50)));
        estimation.setMin(getTicketForTime(tickets, stats.getMin()));
        estimation.setMax(getTicketForTime(tickets, stats.getMax()));
        estimation.setClosestToMean(getTicketForTime(tickets, stats.getMean()));

        return estimation;
    }

    private GlpiTicketsContent getClosestTicketToValue(List<GlpiTicketsContent> tickets, double value) {
        return tickets.stream()
                .min(Comparator.comparingDouble(ticket -> Math.abs(getResolutionTime(ticket) - value)))
                .orElse(null);
    }

    private double getResolutionTime(GlpiTicketsContent ticket) {
        return Duration
                .between(ticket.getDateCreation(), ticket.getSolvedate())
                .toMillis() / (1000 * 60 * 60);
    }

    private GlpiTicketsContent getTicketForTime(List<GlpiTicketsContent> tickets, double time) {
        return tickets.stream()
                .filter(ticket -> getResolutionTime(ticket) == time)
                .findFirst()
                .orElse(null);
    }
}
