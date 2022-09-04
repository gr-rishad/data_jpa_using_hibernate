package com.clinicalapis.Clinical.API.repositories;

import com.clinicalapis.Clinical.API.entities.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalRepository extends JpaRepository<ClinicalData, Integer> {
}
