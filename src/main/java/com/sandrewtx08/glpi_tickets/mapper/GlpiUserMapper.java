package com.sandrewtx08.glpi_tickets.mapper;

import org.mapstruct.Mapper;

import com.sandrewtx08.glpi_tickets.dto.GlpiUserResponseDTO;
import com.sandrewtx08.glpi_tickets.model.GlpiUsers;

@Mapper(componentModel = "spring")
public interface GlpiUserMapper {
    public GlpiUserResponseDTO toDto(GlpiUsers user);
}
