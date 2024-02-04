package ru.kutnyashenko.ktelabs.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kutnyashenko.ktelabs.testtask.entity.Doctor;
import ru.kutnyashenko.ktelabs.testtask.entity.Patient;
import ru.kutnyashenko.ktelabs.testtask.entity.Ticket;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


    List<Ticket> findByOwnerDoctorIdAndOwnerPatientIdIsNullAndAppointmentDateIs(Doctor doctorId, LocalDate date);

    @Query(value = "update Ticket t set t.ownerPatientId = ?1 where t.id = ?2")
    void takeSlotByPatientId(Patient patient, int ticketId);

    List<Ticket> findTicketByOwnerPatientId(Patient patient);
}
