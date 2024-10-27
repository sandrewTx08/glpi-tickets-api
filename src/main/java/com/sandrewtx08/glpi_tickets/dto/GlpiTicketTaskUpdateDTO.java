package com.sandrewtx08.glpi_tickets.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class GlpiTicketTaskUpdateDTO {
    @Min(0)
    @Nullable
    private Integer actionTime;

    @Nullable
    private String content;
}
