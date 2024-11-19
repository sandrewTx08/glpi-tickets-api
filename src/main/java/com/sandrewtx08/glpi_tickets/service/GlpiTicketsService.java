package com.sandrewtx08.glpi_tickets.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandrewtx08.glpi_tickets.predicate.GlpiTicketsSpecification;
import com.sandrewtx08.glpi_tickets.projection.GlpiPendingTickets;
import com.sandrewtx08.glpi_tickets.model.GlpiTickets;
import com.sandrewtx08.glpi_tickets.repository.GlpiTicketsRepository;

@Service
public class GlpiTicketsService {
    @Autowired
    private GlpiTicketsRepository glpiTicketsRepository;

    @Autowired
    private GlpiUsersService glpiUsersService;

    @Transactional(readOnly = true)
    public List<GlpiPendingTickets> findManyTicketsByUserId(Pageable pageable) {
        return glpiTicketsRepository.findManyTicketsByUserId(pageable,
                glpiUsersService
                        .currentUser()
                        .getId());
    }

    @Transactional(readOnly = false)
    public void updateTicketDateMod(Integer ticketId) {
        glpiTicketsRepository.findById(ticketId).ifPresent(glpiTicket -> {
            glpiTicket.setDateMod(LocalDateTime.now());
            glpiTicketsRepository.save(glpiTicket);
        });
    }

    @Transactional(readOnly = true)
    public List<GlpiTickets> findManyTicketsContent(Set<String> content) {
        return glpiTicketsRepository.findAll(GlpiTicketsSpecification.hasContentIn(content));
    }
}
