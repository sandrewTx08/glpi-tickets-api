package com.sandrewtx08.glpi_tickets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandrewtx08.glpi_tickets.dto.GlpiUserResponseDTO;
import com.sandrewtx08.glpi_tickets.mapper.GlpiUserMapper;
import com.sandrewtx08.glpi_tickets.service.GlpiUsersService;

@RestController
@RequestMapping("user")
public class GlpiUsersController {
	@Autowired
	private GlpiUserMapper userMapper;

	@Autowired
	private GlpiUsersService glpiUsersService;

	@GetMapping
	public GlpiUserResponseDTO current() {
		return userMapper.toDto(glpiUsersService.currentUser());
	}
}
