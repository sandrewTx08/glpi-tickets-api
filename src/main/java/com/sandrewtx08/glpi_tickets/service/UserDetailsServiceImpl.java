package com.sandrewtx08.glpi_tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandrewtx08.glpi_tickets.model.GlpiUsers;
import com.sandrewtx08.glpi_tickets.repository.GlpiUsersRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private GlpiUsersRepository glpiUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        GlpiUsers user = glpiUserRepository.findOneByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }
}
