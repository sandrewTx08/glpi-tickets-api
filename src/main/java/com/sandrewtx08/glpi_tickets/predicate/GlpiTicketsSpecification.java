package com.sandrewtx08.glpi_tickets.predicate;

import java.util.Set;

import org.springframework.data.jpa.domain.Specification;

import com.sandrewtx08.glpi_tickets.model.GlpiTickets;

import jakarta.persistence.criteria.Predicate;

public class GlpiTicketsSpecification {
    public static Specification<GlpiTickets> hasContentIn(Set<String> contents) {
        return (root, query, builder) -> {
            Predicate[] predicates = contents.stream()
                    .map(content -> builder.or(
                            builder.like(root.get("name"), "%" + content + "%"),
                            builder.like(root.get("content"), "%" + content + "%")))
                    .toArray(Predicate[]::new);

            return builder.and(
                    builder.isNotNull(root.get("solvedate")),
                    builder.or(predicates));
        };
    }
}
