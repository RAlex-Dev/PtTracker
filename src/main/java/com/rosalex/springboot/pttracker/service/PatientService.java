package com.rosalex.springboot.pttracker.service;

import com.rosalex.springboot.pttracker.entity.Patient;
import com.rosalex.springboot.pttracker.entity.QAIRecord;

import java.util.List;

public interface PatientService {

    public void save(Patient patient);

    public Patient findById(int id);

    public List<Patient> findAll();

    public void deleteById(int id);

}
