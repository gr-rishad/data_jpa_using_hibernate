package com.clinicalapis.Clinical.API.controllers;

import com.clinicalapis.Clinical.API.dto.ClinicalDataRequest;
import com.clinicalapis.Clinical.API.entities.ClinicalData;
import com.clinicalapis.Clinical.API.entities.Patient;
import com.clinicalapis.Clinical.API.repositories.ClinicalRepository;
import com.clinicalapis.Clinical.API.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalController {

    private final ClinicalRepository clinicalRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public ClinicalController(ClinicalRepository clinicalRepository, PatientRepository patientRepository) {
        this.clinicalRepository = clinicalRepository;
        this.patientRepository = patientRepository;
    }


    @PostMapping("/clinicals")
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest clinicalDataRequest) {
        Patient patient = patientRepository.findById(clinicalDataRequest.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(clinicalDataRequest.getComponentName());
        clinicalData.setComponentValue(clinicalDataRequest.getComponentValue());
        clinicalData.setPatient(patient);

        return clinicalRepository.save(clinicalData);
    }
}
