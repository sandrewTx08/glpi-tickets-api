package com.sandrewtx08.glpi_tickets.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sandrewtx08.glpi_tickets.model.GlpiUsers;

@Service
public class GlpiUsersService {
    public GlpiUsers currentUser() {
        GlpiUsers user = (GlpiUsers) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        return user;
    }
}
