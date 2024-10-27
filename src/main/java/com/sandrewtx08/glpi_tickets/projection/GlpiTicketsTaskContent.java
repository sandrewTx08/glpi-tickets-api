package com.sandrewtx08.glpi_tickets.projection;

import java.time.LocalDateTime;

public interface GlpiTicketsTaskContent {
    Integer getId();

    Integer getTicketsId();

    String getContent();

    Integer getActionTime();

    LocalDateTime getDateMod();
}
