package com.clinicalapis.Clinical.API.repositories;

import com.clinicalapis.Clinical.API.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
