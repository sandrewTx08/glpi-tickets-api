package com.sandrewtx08.glpi_tickets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "glpi_tickets_users")
@Data
public class GlpiTicketsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tickets_id", nullable = false)
    private Integer ticketsId;

    @Column(name = "users_id", nullable = false)
    private Integer usersId;

    @Column(nullable = false)
    private Integer type;

    @Column(name = "use_notification", nullable = false)
    private Boolean useNotification;

    @Column(name = "alternative_email")
    private String alternativeEmail;
}
