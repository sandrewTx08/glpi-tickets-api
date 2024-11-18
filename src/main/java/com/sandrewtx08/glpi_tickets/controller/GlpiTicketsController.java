package com.sandrewtx08.glpi_tickets.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sandrewtx08.glpi_tickets.dto.TicketSolveEstimation;
import com.sandrewtx08.glpi_tickets.projection.GlpiPendingTickets;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsContent;
import com.sandrewtx08.glpi_tickets.service.GlpiTicketsService;
import com.sandrewtx08.glpi_tickets.service.TicketSolveService;

@RestController
@RequestMapping("tickets")
public class GlpiTicketsController {
    @Autowired
    private GlpiTicketsService glpiTicketService;

    @Autowired
    private TicketSolveService ticketSolveService;

    @GetMapping
    public List<GlpiPendingTickets> findManyTicketsByUserId(
            @PageableDefault(size = 50, page = 0) Pageable pageable) {
        return glpiTicketService.findManyTicketsByUserId(pageable);
    }

    @GetMapping("estimation")
    public TicketSolveEstimation findManyTicketsContent(
            @RequestParam Set<String> content) {
        List<GlpiTicketsContent> tickets = glpiTicketService.findManyTicketsContent(content);
        TicketSolveEstimation ticketSolveEstimation = ticketSolveService.estimateTicketSolveTime(tickets);
        return ticketSolveEstimation;
    }
}
