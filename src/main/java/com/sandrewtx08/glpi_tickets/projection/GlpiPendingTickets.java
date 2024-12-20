package com.sandrewtx08.glpi_tickets.projection;

import java.time.LocalDateTime;

public interface GlpiPendingTickets {
    Integer getId();

    String getName();

    LocalDateTime getDate();

    LocalDateTime getSolvedate();

    LocalDateTime getDateMod();

    Integer getStatus();

    String getContent();

    Integer getUrgency();

    Integer getImpact();

    Integer getPriority();

    LocalDateTime getDateCreation();
}
