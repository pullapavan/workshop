package com.skillaid.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.skillaid.workshop.dto.RegistrationResponse;
import com.skillaid.workshop.entities.Registrations;
import com.skillaid.workshop.repositories.RegistrationsRepository;

@Service
public class RegistrationsService {
	
	@Autowired
	private RegistrationsRepository registrationsRepository;
	
	public List<Registrations> registrations(){
		return registrationsRepository.findAll();
	}
	
	public RegistrationResponse registerNewStudent(Registrations newStudent) {
		Registrations savedStudentDetails = registrationsRepository.save(newStudent);
		if(savedStudentDetails == null) {
			throw new IllegalArgumentException("Registration Failed!!!");
		}
		
		return RegistrationResponse
				.builder()
				.status(HttpStatus.CREATED.value())
				.details(savedStudentDetails)
                .build();		
	}

}
