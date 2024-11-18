package com.sandrewtx08.glpi_tickets.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sandrewtx08.glpi_tickets.model.GlpiUsers;

public interface GlpiUsersRepository extends JpaRepository<GlpiUsers, Integer> {
    Optional<GlpiUsers> findOneByName(String username);
}
