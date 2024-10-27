package com.sandrewtx08.glpi_tickets.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandrewtx08.glpi_tickets.model.GlpiTicketTask;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsTaskContent;

public interface GlpiTicketTaskRepository extends JpaRepository<GlpiTicketTask, Integer> {
    @Query("""
            SELECT tt FROM GlpiTicketTask tt
            WHERE tt.ticketsId = :ticketId
            """)
    public List<GlpiTicketsTaskContent> findManyTicketTaskByTicketId(Pageable pageable,
            @Param("ticketId") Integer ticketId);
}
