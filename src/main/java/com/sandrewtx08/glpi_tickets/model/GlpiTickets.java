package com.sandrewtx08.glpi_tickets.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "glpi_tickets")
@Data
public class GlpiTickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "entities_id", nullable = false)
    private Integer entitiesId;

    private String name;

    private LocalDateTime date;
    private LocalDateTime closedate;
    private LocalDateTime solvedate;

    @Column(name = "date_mod")
    private LocalDateTime dateMod;

    @Column(name = "users_id_lastupdater", nullable = false)
    private Integer usersIdLastupdater;

    @Column(nullable = false)
    private Integer status;

    @Column(name = "users_id_recipient", nullable = false)
    private Integer usersIdRecipient;

    @Column(name = "requesttypes_id", nullable = false)
    private Integer requesttypesId;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @Column(nullable = false)
    private Integer urgency;

    @Column(nullable = false)
    private Integer impact;

    @Column(nullable = false)
    private Integer priority;

    @Column(name = "itilcategories_id", nullable = false)
    private Integer itilcategoriesId;

    @Column(nullable = false)
    private Integer type;

    @Column(name = "solutiontypes_id", nullable = false)
    private Integer solutiontypesId;

    @Column(columnDefinition = "LONGTEXT")
    private String solution;

    @Column(name = "global_validation", nullable = false)
    private Integer globalValidation;

    @Column(name = "slts_tto_id", nullable = false)
    private Integer sltsTtoId;

    @Column(name = "slts_ttr_id", nullable = false)
    private Integer sltsTtrId;

    @Column(name = "ttr_slalevels_id", nullable = false)
    private Integer ttrSlalevelsId;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "time_to_own")
    private LocalDateTime timeToOwn;

    @Column(name = "begin_waiting_date")
    private LocalDateTime beginWaitingDate;

    @Column(name = "sla_waiting_duration", nullable = false)
    private Integer slaWaitingDuration;

    @Column(name = "waiting_duration", nullable = false)
    private Integer waitingDuration;

    @Column(name = "close_delay_stat", nullable = false)
    private Integer closeDelayStat;

    @Column(name = "solve_delay_stat", nullable = false)
    private Integer solveDelayStat;

    @Column(name = "takeintoaccount_delay_stat", nullable = false)
    private Integer takeintoaccount_delay_stat;

    @Column(nullable = false)
    private Integer actiontime;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "locations_id", nullable = false)
    private Integer locationsId;

    @Column(name = "validation_percent", nullable = false)
    private Integer validationPercent;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
}
