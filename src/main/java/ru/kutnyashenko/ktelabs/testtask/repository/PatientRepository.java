package ru.kutnyashenko.ktelabs.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kutnyashenko.ktelabs.testtask.entity.Patient;
import ru.kutnyashenko.ktelabs.testtask.entity.Ticket;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findById(int id);

}
