package ru.kutnyashenko.ktelabs.testtask.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @JsonBackReference
    private Doctor ownerDoctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    @JsonBackReference
    private Patient ownerPatientId;

    @Column(name = "appointment_date")
    LocalDate appointmentDate;

    @Column(name = "appointment_time")
    LocalTime appointmentTime;

    public Ticket(Doctor ownerDoctorId, LocalDate appointmentDate, LocalTime appointmentTime) {
        this.ownerDoctorId = ownerDoctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }
}
