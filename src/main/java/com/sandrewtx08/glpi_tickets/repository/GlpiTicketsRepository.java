package com.sandrewtx08.glpi_tickets.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sandrewtx08.glpi_tickets.model.GlpiTickets;
import com.sandrewtx08.glpi_tickets.projection.GlpiPendingTickets;

public interface GlpiTicketsRepository
                extends JpaRepository<GlpiTickets, Integer>, JpaSpecificationExecutor<GlpiTickets> {
        @Query("""
                        SELECT t FROM GlpiTicketsUsers tu
                        JOIN GlpiTickets t
                        ON t.id = tu.ticketsId
                        AND t.isDeleted = FALSE
                        AND (
                                EXISTS (
                                        SELECT 1 FROM GlpiTicketsUsers ts
                                        WHERE ts.ticketsId = t.id
                                        AND ts.usersId = :userId
                                )
                                OR EXISTS (
                                        SELECT 1 FROM GlpiGroupsTickets gt
                                        WHERE gt.ticketsId = t.id
                                        AND gt.groupsId = (
                                                SELECT gu.id FROM GlpiGroupsUsers gu
                                                WHERE gt.groupsId = gu.id
                                                AND gu.usersId = :userId
                                        )
                                )
                        )
                        """)
        List<GlpiPendingTickets> findManyTicketsByUserId(Pageable pageable,
                        @Param("userId") Integer userId);
}
