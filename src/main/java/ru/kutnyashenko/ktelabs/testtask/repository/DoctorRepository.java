package ru.kutnyashenko.ktelabs.testtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kutnyashenko.ktelabs.testtask.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

    public Doctor findById(int id);
}
