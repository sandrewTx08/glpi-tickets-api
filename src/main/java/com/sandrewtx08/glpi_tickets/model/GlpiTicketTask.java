package com.sandrewtx08.glpi_tickets.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Table(name = "glpi_tickettasks")
@Data
public class GlpiTicketTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tickets_id", nullable = false)
    private int ticketsId;

    @Column(name = "taskcategories_id", nullable = false)
    private int taskCategoriesId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @Column(name = "users_id", nullable = false)
    private int usersId;

    @Lob
    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "is_private", nullable = false)
    private boolean isPrivate;

    @Column(name = "actiontime", nullable = false)
    private int actionTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "begin")
    private Date begin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end")
    private Date end;

    @Column(name = "state", nullable = false)
    private int state;

    @Column(name = "users_id_tech", nullable = false)
    private int usersIdTech;

    @Column(name = "groups_id_tech", nullable = false)
    private int groupsIdTech;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_mod")
    private Date dateMod;
}
