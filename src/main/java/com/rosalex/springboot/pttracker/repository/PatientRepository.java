package com.rosalex.springboot.pttracker.repository;

import com.rosalex.springboot.pttracker.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
