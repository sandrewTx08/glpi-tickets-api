package com.sandrewtx08.glpi_tickets.projection;

import java.time.LocalDateTime;

public interface GlpiTicketsContent {
    String getName();

    String getContent();

    LocalDateTime getDateCreation();

    LocalDateTime getSolvedate();
}
