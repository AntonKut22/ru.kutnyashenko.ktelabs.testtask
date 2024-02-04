package ru.kutnyashenko.ktelabs.testtask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kutnyashenko.ktelabs.testtask.repository.DoctorRepository;
import ru.kutnyashenko.ktelabs.testtask.repository.TicketRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, TicketRepository ticketRepository) {
        this.doctorRepository = doctorRepository;
        this.ticketRepository = ticketRepository;
    }


}
