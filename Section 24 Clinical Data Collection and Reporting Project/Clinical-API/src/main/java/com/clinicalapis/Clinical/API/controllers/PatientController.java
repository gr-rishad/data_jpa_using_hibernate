package com.clinicalapis.Clinical.API.controllers;

import com.clinicalapis.Clinical.API.entities.Patient;
import com.clinicalapis.Clinical.API.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    private PatientRepository patientRepository;


    @Autowired
    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatient(@PathVariable int id) {
        return patientRepository.findById(id).get();
    }

    @PostMapping("/patients")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/patients/analyze/{id}")
    public Patient analyze(@PathVariable int id) {

//        Patient patient= patientRepository.findById(id).get();
//        patient.setClinicalData();
        return null;

    }


}
