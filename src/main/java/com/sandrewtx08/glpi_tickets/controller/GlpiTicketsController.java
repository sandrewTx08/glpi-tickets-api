package com.sandrewtx08.glpi_tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandrewtx08.glpi_tickets.projection.GlpiPendingTickets;
import com.sandrewtx08.glpi_tickets.service.GlpiTicketsService;

@RestController
@RequestMapping("tickets")
public class GlpiTicketsController {
    @Autowired
    private GlpiTicketsService glpiTicketService;

    @GetMapping
    public List<GlpiPendingTickets> findManyTicketsByUserId(
            @PageableDefault(size = 50, page = 0) Pageable pageable) {
        return glpiTicketService.findManyTicketsByUserId(pageable);
    }
}
