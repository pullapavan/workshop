package com.skillaid.workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillaid.workshop.dto.ServerResponse;
import com.skillaid.workshop.entities.Registrations;
import com.skillaid.workshop.services.RegistrationsService;

@RestController
@RequestMapping("/api/")
public class RegistrationsController {
	
	@Autowired
	private RegistrationsService registrationsService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(path = "registrations", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Registrations> registrations(){
		return registrationsService.registrations();
	}
	
	@PostMapping(path = "registrations", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServerResponse> registerNewUser(@RequestBody Registrations newregistration){
		return new ResponseEntity<ServerResponse>(registrationsService.registerNewStudent(newregistration), HttpStatus.CREATED);
	}
}
