package com.sandrewtx08.glpi_tickets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "glpi_groups_users")
public class GlpiGroupsUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "users_id", nullable = false, columnDefinition = "int default 0")
    private int usersId;

    @Column(name = "groups_id", nullable = false, columnDefinition = "int default 0")
    private int groupsId;

    @Column(name = "is_dynamic", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isDynamic;

    @Column(name = "is_manager", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isManager;

    @Column(name = "is_userdelegate", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isUserdelegate;
}
