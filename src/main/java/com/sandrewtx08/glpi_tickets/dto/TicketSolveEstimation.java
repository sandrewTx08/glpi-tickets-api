package com.sandrewtx08.glpi_tickets.dto;

import com.sandrewtx08.glpi_tickets.model.GlpiTickets;

import lombok.Data;

@Data
public class TicketSolveEstimation {
    private GlpiTickets mean;
    private GlpiTickets stdDev;
    private GlpiTickets median;
    private GlpiTickets min;
    private GlpiTickets max;
    private int totalTickets;
}
