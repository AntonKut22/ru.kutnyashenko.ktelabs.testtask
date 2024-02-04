package ru.kutnyashenko.ktelabs.testtask.service;

import jakarta.jws.WebService;
import org.springframework.transaction.annotation.Transactional;
import ru.kutnyashenko.ktelabs.testtask.entity.Ticket;
import ru.kutnyashenko.ktelabs.testtask.repository.DoctorRepository;
import ru.kutnyashenko.ktelabs.testtask.repository.TicketRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@WebService(serviceName = "ScheduleService",
        portName = "SchedulePort",
        targetNamespace = "http://service.ws.schedule/",
        endpointInterface = "ru.kutnyashenko.ktelabs.testtask.service.HelloService"
)
public class HelloServiceImpl implements HelloService {

    private final DoctorRepository doctorRepository;
    private final TicketRepository ticketRepository;

    public HelloServiceImpl(DoctorRepository doctorRepository, TicketRepository ticketRepository) {
        this.doctorRepository = doctorRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional
    public String createSchedule(Date startDataTime, int durationTicket, int doctorId, int countTicketInDay) {
        LocalDateTime startTicket = startDataTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        LocalDate date = startTicket.toLocalDate();
        LocalTime time = startTicket.toLocalTime();

        for (int i = 0; i < countTicketInDay; i++) {
            Ticket ticket = new Ticket(doctorRepository.findById(doctorId), date, time);
            ticketRepository.save(ticket);
            time = time.plusMinutes(durationTicket);
        }
        return "OK";
    }
}
