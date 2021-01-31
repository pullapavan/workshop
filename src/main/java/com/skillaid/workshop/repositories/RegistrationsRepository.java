package com.skillaid.workshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillaid.workshop.entities.Registrations;

@Repository
public interface RegistrationsRepository extends JpaRepository<Registrations, Long> {

}
