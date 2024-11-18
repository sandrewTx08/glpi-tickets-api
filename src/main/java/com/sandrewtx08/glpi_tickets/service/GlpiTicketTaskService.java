package com.sandrewtx08.glpi_tickets.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandrewtx08.glpi_tickets.dto.GlpiTicketTaskUpdateDTO;
import com.sandrewtx08.glpi_tickets.model.GlpiTicketTask;
import com.sandrewtx08.glpi_tickets.projection.GlpiTicketsTaskContent;
import com.sandrewtx08.glpi_tickets.repository.GlpiTicketTaskRepository;

@Service
public class GlpiTicketTaskService {
    @Autowired
    private GlpiTicketTaskRepository glpiTicketTaskRepository;

    @Autowired
    private GlpiTicketsService glpiTicketsService;

    @Autowired
    private GlpiUsersService glpiUsersService;

    @Transactional(readOnly = true)
    public List<GlpiTicketsTaskContent> findManyByTicketsId(Pageable pageable, Integer ticketItemId) {
        return glpiTicketTaskRepository.findManyByTicketsId(pageable,
                ticketItemId);
    }

    @Transactional(readOnly = false)
    public void update(Integer id, GlpiTicketTaskUpdateDTO dto) {
        GlpiTicketTask glpiTicketTask = glpiTicketTaskRepository.getReferenceById(id);
        glpiTicketTask.setDateMod(new Date());
        glpiTicketTask.setUsersIdTech(glpiUsersService.currentUser().getId());
        glpiTicketTask.setUsersId(glpiUsersService.currentUser().getId());

        if (dto.getActionTime() != null) {
            glpiTicketTask.setActionTime(dto.getActionTime());
        }

        if (dto.getContent() != null) {
            glpiTicketTask.setContent(dto.getContent());
        }

        glpiTicketTaskRepository.save(glpiTicketTask);
        glpiTicketsService.updateTicketDateMod(glpiTicketTask.getTicketsId());
    }

    @Transactional(readOnly = false)
    public void create(Integer ticketId) {
        GlpiTicketTask glpiTicketTask = new GlpiTicketTask();
        glpiTicketTask.setTicketsId(ticketId);
        glpiTicketTask.setUsersId(glpiUsersService.currentUser().getId());
        glpiTicketTask.setUsersIdTech(glpiUsersService.currentUser().getId());
        glpiTicketTask.setDate(new Date());
        glpiTicketTask.setDateMod(new Date());
        glpiTicketTaskRepository.save(glpiTicketTask);
        glpiTicketsService.updateTicketDateMod(ticketId);
    }
}
