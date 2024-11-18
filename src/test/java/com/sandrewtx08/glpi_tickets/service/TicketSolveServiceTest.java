package com.sandrewtx08.glpi_tickets.service;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sandrewtx08.glpi_tickets.BaseTestConfig;
import com.sandrewtx08.glpi_tickets.dto.TicketSolveEstimation;
import com.sandrewtx08.glpi_tickets.model.GlpiTickets;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsContent;
import com.sandrewtx08.glpi_tickets.repository.GlpiTicketsRepository;

@SpringBootTest
public class TicketSolveServiceTest extends BaseTestConfig {
    @Autowired
    private TicketSolveService ticketSolveService;

    @Autowired
    private GlpiTicketsRepository glpiTicketsRepository;

    @Autowired
    private GlpiTicketsService glpiTicketsService;

    public static List<GlpiTickets> generateRandomTickets(int count) {
        Random random = new Random();

        return IntStream.range(0, count)
                .mapToObj(i -> {
                    GlpiTickets ticket = new GlpiTickets();
                    ticket.setId(i + 1);
                    ticket.setEntitiesId(random.nextInt(5) + 1);
                    ticket.setName("Ticket " + (i + 1));
                    ticket.setDate(LocalDateTime.now().minusHours(1200));
                    ticket.setSolvedate(LocalDateTime.now().minusMinutes(random.nextInt(320)));
                    ticket.setDateCreation(LocalDateTime.now().minusMinutes(1200));
                    ticket.setDateMod(LocalDateTime.now());
                    ticket.setUsersIdLastupdater(random.nextInt(10) + 1);
                    ticket.setStatus(random.nextInt(5) + 1);
                    ticket.setUsersIdRecipient(random.nextInt(10) + 1);
                    ticket.setRequesttypesId(random.nextInt(3) + 1);
                    ticket.setContent("Test content " + (i + 1));
                    ticket.setUrgency(random.nextInt(5) + 1);
                    ticket.setImpact(random.nextInt(5) + 1);
                    ticket.setPriority(random.nextInt(5) + 1);
                    ticket.setItilcategoriesId(random.nextInt(5) + 1);
                    ticket.setType(random.nextInt(3) + 1);
                    ticket.setSolutiontypesId(random.nextInt(3) + 1);
                    ticket.setSolution("Solution " + (i + 1));
                    ticket.setGlobalValidation(random.nextInt(3) + 1);
                    ticket.setSltsTtoId(random.nextInt(3) + 1);
                    ticket.setSltsTtrId(random.nextInt(3) + 1);
                    ticket.setTtrSlalevelsId(random.nextInt(3) + 1);
                    ticket.setSlaWaitingDuration(random.nextInt(100));
                    ticket.setWaitingDuration(random.nextInt(100));
                    ticket.setCloseDelayStat(random.nextInt(100));
                    ticket.setSolveDelayStat(random.nextInt(100));
                    ticket.setTakeintoaccount_delay_stat(random.nextInt(100));
                    ticket.setActiontime(random.nextInt(100));
                    ticket.setIsDeleted(false);
                    ticket.setLocationsId(random.nextInt(5) + 1);
                    ticket.setValidationPercent(random.nextInt(100));
                    return ticket;
                })
                .collect(Collectors.toList());
    }

    private final List<GlpiTickets> randomTickets = generateRandomTickets(100);

    @BeforeEach
    public void beforeEach() {
        glpiTicketsRepository.saveAll(randomTickets);
    }

    @AfterEach
    public void afterEach() {
        glpiTicketsRepository.deleteAll(randomTickets);
    }

    @Test
    public void testTicketResolutionService() {
        List<GlpiTicketsContent> tickets = glpiTicketsService.findManyTicketsContent(Set.of("9", "8"));
        TicketSolveEstimation ticketSolveEstimation = ticketSolveService.estimateTicketSolveTime(tickets);
        assertTrue(
                ticketSolveEstimation.getMax().getSolvedate().isAfter(ticketSolveEstimation.getMin().getSolvedate()));
        assertTrue(
                ticketSolveEstimation.getMin().getSolvedate().isBefore(ticketSolveEstimation.getMax().getSolvedate()));
    }
}
