package com.skillaid.workshop.dto;

import com.skillaid.workshop.entities.Registrations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponse implements ServerResponse {

	private int status;
	private Registrations details;

}
