package com.patient_scheduling.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime appointmentTime;
    private boolean started;
    private boolean ended;
    private String reason;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;
}
