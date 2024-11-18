package com.sandrewtx08.glpi_tickets.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sandrewtx08.glpi_tickets.model.GlpiTicketTask;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsTaskContent;

public interface GlpiTicketTaskRepository extends JpaRepository<GlpiTicketTask, Integer> {
        List<GlpiTicketsTaskContent> findManyByTicketsId(Pageable pageable,
                        @Param("ticketId") Integer ticketId);
}
