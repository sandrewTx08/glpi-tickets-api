package com.sandrewtx08.glpi_tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandrewtx08.glpi_tickets.dto.GlpiTicketTaskUpdateDTO;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsTaskContent;
import com.sandrewtx08.glpi_tickets.service.GlpiTicketTaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("ticket-task")
public class GlpiTicketTaskController {
    @Autowired
    private GlpiTicketTaskService glpiTicketTaskService;

    @GetMapping("ticket/{ticketId}")
    public List<GlpiTicketsTaskContent> findManyByTicketsId(
            @PageableDefault(size = 10, page = 0) Pageable pageable,
            @PathVariable("ticketId") Integer ticketId) {
        return glpiTicketTaskService.findManyByTicketsId(pageable, ticketId);
    }

    @PostMapping("ticket/{ticketId}")
    public void create(
            @PathVariable("ticketId") Integer ticketId) {
        glpiTicketTaskService.create(ticketId);
    }

    @PatchMapping("{id}")
    public void update(
            @PathVariable("id") Integer id,
            @Valid @RequestBody GlpiTicketTaskUpdateDTO dto) {
        glpiTicketTaskService.update(id, dto);
    }
}
