package com.patient_scheduling.repositories;

import com.patient_scheduling.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
