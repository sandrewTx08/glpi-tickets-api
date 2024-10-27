package com.sandrewtx08.glpi_tickets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "glpi_groups_tickets")
public class GlpiGroupsTickets {
    @Id
    private Integer id;

    @Column(name = "tickets_id", nullable = false, columnDefinition = "int default 0")
    private Integer ticketsId;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private Integer groupsId;

    @Column(name = "type", nullable = false, columnDefinition = "int default 1")
    private Integer type;
}
