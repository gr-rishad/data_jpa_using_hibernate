package com.patient_scheduling;

import com.patient_scheduling.entities.Appointment;
import com.patient_scheduling.entities.Doctor;
import com.patient_scheduling.entities.Insurance;
import com.patient_scheduling.entities.Patient;
import com.patient_scheduling.repositories.AppointmentRepository;
import com.patient_scheduling.repositories.DoctorRepository;
import com.patient_scheduling.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class PatientSchedulingApplicationTests {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreateDoctor() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("Golam Rabbani");
        doctor.setLastName("Rishad");
        doctor.setSpeciality("All");

        doctorRepository.save(doctor);
    }

    @Test
    public void testCreatePatient() {
        Patient patient = new Patient();
        patient.setFirstName("Sabbir");
        patient.setLastName("Ahmed");
        patient.setPhone("1767292882");
        patient.setInsurance(new Insurance("Blue Cross Blue Shield", 20d));

        Optional<Doctor> doctor = doctorRepository.findById(1l);
        List<Doctor> doctors = Arrays.asList(doctor.get());
        patient.setDoctors(doctors);

        patientRepository.save(patient);

    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment();
        appointment.setAppointmentTime(LocalDateTime.now());
        appointment.setReason("I have a problem");
        appointment.setStarted(true);

        appointment.setPatient(patientRepository.findById(1l).get());
        appointment.setDoctor(doctorRepository.findById(1l).get());

        appointmentRepository.save(appointment);
    }

}
