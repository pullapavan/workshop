package com.skillaid.workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillaid.workshop.services.RegistrationsService;

@Controller
@RequestMapping("/")
public class TemplateController {

	@Autowired
	private RegistrationsService service;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/admin/main")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String main(Model model) {
		model.addAttribute("registrations", service.registrations());
		return "main";
	}

}
