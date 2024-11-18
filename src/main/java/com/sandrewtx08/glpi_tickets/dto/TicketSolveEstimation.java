package com.sandrewtx08.glpi_tickets.dto;

import java.util.Map;

import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsContent;

import lombok.Data;

@Data
public class TicketSolveEstimation {
    private GlpiTicketsContent mean;
    private GlpiTicketsContent stdDev;
    private GlpiTicketsContent median;
    private GlpiTicketsContent min;
    private GlpiTicketsContent max;
    private GlpiTicketsContent closestToMean;
    private Map<Integer, TicketSolveEstimation> meanByUrgency;
    private int totalTickets;
}
