package com.skillaid.workshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student_registrations")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registrations {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "student_name", length = 50, nullable = false, unique = false)
	private String studentName;

	@Column(name = "student_email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "student_gender", nullable = true, unique = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "student_college", nullable = false, unique = false)
	private String college;

	@Column(name = "student_stream", nullable = false, unique = false)
	private String stream;

	@Column(name = "student_mobile", nullable = true, unique = false)
	private String mobile;

}
