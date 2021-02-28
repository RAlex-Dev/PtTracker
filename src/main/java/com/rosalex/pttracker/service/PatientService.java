package com.rosalex.pttracker.service;


import com.rosalex.pttracker.entity.Patient;

import java.util.List;

public interface PatientService {

    public void save(Patient patient);

    public Patient findById(int id);

    public List<Patient> findAll();

    public void deleteById(int id);

}
