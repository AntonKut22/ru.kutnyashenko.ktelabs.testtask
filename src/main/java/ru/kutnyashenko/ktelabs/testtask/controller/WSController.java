package ru.kutnyashenko.ktelabs.testtask.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.kutnyashenko.ktelabs.testtask.entity.Ticket;
import ru.kutnyashenko.ktelabs.testtask.repository.DoctorRepository;
import ru.kutnyashenko.ktelabs.testtask.repository.PatientRepository;
import ru.kutnyashenko.ktelabs.testtask.repository.TicketRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
public class WSController {

    private final TicketRepository ticketRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public WSController(TicketRepository ticketRepository,
                        DoctorRepository doctorRepository,
                        PatientRepository patientRepository) {
        this.ticketRepository = ticketRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }
        @GetMapping("/schedule/{id}/{date}")
    public List<Ticket> findFreeTicketTheDoctor(@PathVariable("id") int id,
                                                @PathVariable("date")
                                                @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
            return ticketRepository.findByOwnerDoctorIdAndOwnerPatientIdIsNullAndAppointmentDateIs(doctorRepository.findById(id), date);
    }

    @PutMapping("/schedule/takeSlot/{idSlot}/patient/{idPatient}")
    public void takeSlotAsPatient(@PathVariable("idSlot") int idTicket,
                                  @PathVariable("idPatient") int idPatient){
        ticketRepository.takeSlotByPatientId(patientRepository.findById(idPatient), idTicket);
    }

    @GetMapping("/schedule/patient/{id}")
    public List<Ticket> getAllTicketAsPatient(@PathVariable("id") int id){
        return ticketRepository.findTicketByOwnerPatientId(patientRepository.findById(id));
    }
}
