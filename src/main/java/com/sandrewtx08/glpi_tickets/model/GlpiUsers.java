package com.sandrewtx08.glpi_tickets.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "glpi_users")
@Data
public class GlpiUsers implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String password;
    private String phone;
    private String phone2;
    private String mobile;
    private String realname;
    private String firstname;

    @Column(name = "locations_id", nullable = false)
    private Integer locationsId;

    private String language;

    @Column(name = "use_mode", nullable = false)
    private Integer useMode;

    @Column(name = "list_limit")
    private Integer listLimit;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @Column(name = "auths_id", nullable = false)
    private Integer authsId;

    @Column(nullable = false)
    private Integer authtype;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "date_mod")
    private LocalDateTime dateMod;

    @Column(name = "date_sync")
    private LocalDateTime dateSync;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "profiles_id", nullable = false)
    private Integer profilesId;

    @Column(name = "entities_id", nullable = false)
    private Integer entitiesId;

    @Column(name = "usertitles_id", nullable = false)
    private Integer usertitlesId;

    @Column(name = "usercategories_id", nullable = false)
    private Integer usercategoriesId;

    @Column(name = "date_format")
    private Integer dateFormat;

    @Column(name = "number_format")
    private Integer numberFormat;

    @Column(name = "names_format")
    private Integer namesFormat;

    @Column(name = "csv_delimiter")
    private String csvDelimiter;

    @Column(name = "is_ids_visible")
    private Boolean isIdsVisible;

    @Column(name = "use_flat_dropdowntree")
    private Boolean useFlatDropdowntree;

    @Column(name = "show_jobs_at_login")
    private Boolean showJobsAtLogin;

    @Column(name = "priority_1")
    private String priority1;

    @Column(name = "priority_2")
    private String priority2;

    @Column(name = "priority_3")
    private String priority3;

    @Column(name = "priority_4")
    private String priority4;

    @Column(name = "priority_5")
    private String priority5;

    @Column(name = "priority_6")
    private String priority6;

    @Column(name = "followup_private")
    private Boolean followupPrivate;

    @Column(name = "task_private")
    private Boolean taskPrivate;

    @Column(name = "default_requesttypes_id")
    private Integer defaultRequesttypesId;

    @Column(name = "password_forget_token")
    private String passwordForgetToken;

    @Column(name = "password_forget_token_date")
    private LocalDateTime passwordForgetTokenDate;

    @Column(name = "user_dn", columnDefinition = "TEXT")
    private String userDn;

    @Column(name = "registration_number")
    private String registrationNumber;

    @Column(name = "show_count_on_tabs")
    private Boolean showCountOnTabs;

    @Column(name = "refresh_ticket_list")
    private Integer refreshTicketList;

    @Column(name = "set_default_tech")
    private Boolean setDefaultTech;

    @Column(name = "personal_token")
    private String personalToken;

    @Column(name = "personal_token_date")
    private LocalDateTime personalTokenDate;

    @Column(name = "display_count_on_home")
    private Integer displayCountOnHome;

    @Column(name = "notification_to_myself")
    private Boolean notificationToMyself;

    @Column(name = "duedateok_color")
    private String duedateokColor;

    @Column(name = "duedatewarning_color")
    private String duedatewarningColor;

    @Column(name = "duedatecritical_color")
    private String duedatecriticalColor;

    @Column(name = "duedatewarning_less")
    private Integer duedatewarningLess;

    @Column(name = "duedatecritical_less")
    private Integer duedatecriticalLess;

    @Column(name = "duedatewarning_unit")
    private String duedatewarningUnit;

    @Column(name = "duedatecritical_unit")
    private String duedatecriticalUnit;

    @Column(name = "display_options", columnDefinition = "TEXT")
    private String displayOptions;

    @Column(name = "is_deleted_ldap", nullable = false)
    private Boolean isDeletedLdap;

    private String pdffont;
    private String picture;

    @Column(name = "begin_date")
    private LocalDateTime beginDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "keep_devices_when_purging_item")
    private Boolean keepDevicesWhenPurgingItem;

    @Column(name = "privatebookmarkorder", columnDefinition = "LONGTEXT")
    private String privatebookmarkorder;

    private Boolean backcreated;

    @Column(name = "task_state")
    private Integer taskState;

    private String layout;
    private String palette;

    @Column(name = "ticket_timeline")
    private Boolean ticketTimeline;

    @Column(name = "ticket_timeline_keep_replaced_tabs")
    private Boolean ticketTimelineKeepReplacedTabs;

    @Column(name = "set_default_requester")
    private Boolean setDefaultRequester;

    @Column(name = "lock_autolock_mode")
    private Boolean lockAutolockMode;

    @Column(name = "lock_directunlock_notification")
    private Boolean lockDirectunlockNotification;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    @Column(name = "highcontrast_css")
    private Boolean highcontrastCss;

    @Column(columnDefinition = "TEXT")
    private String plannings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return realname;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isDeleted == null || !isDeleted;
    }
}
