package com.rosalex.pttracker.service;


import com.rosalex.pttracker.entity.Patient;
import com.rosalex.pttracker.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;

    // constructor dependency injection

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    // CRUD operations

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient findById(int id) {
        Optional<Patient> result = patientRepository.findById(id);

        Patient patient = null;
        if(result.isPresent()){
            patient = result.get();
        } else{
            throw new RuntimeException("patient: " + id + " not found");
        }

        return patient;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        patientRepository.deleteById(id);
    }

}
