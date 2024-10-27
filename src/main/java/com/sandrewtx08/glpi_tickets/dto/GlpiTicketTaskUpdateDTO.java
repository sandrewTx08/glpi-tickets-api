package com.sandrewtx08.glpi_tickets.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class GlpiTicketTaskUpdateDTO {
    @Min(60)
    private Integer actionTime;

    @NotBlank
    private String content;
}
