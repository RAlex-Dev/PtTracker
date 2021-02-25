package com.rosalex.springboot.pttracker.service;

import com.rosalex.springboot.pttracker.entity.CurrentTreatmentRecord;
import com.rosalex.springboot.pttracker.entity.DialysisTreatmentRecord;
import com.rosalex.springboot.pttracker.entity.Patient;
import com.rosalex.springboot.pttracker.repository.CurrentTxRecordRepository;
import com.rosalex.springboot.pttracker.repository.DialysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DialysisServiceImpl implements DialysisService{

    DialysisRepository dialysisRepository;
    CurrentTxRecordRepository currentTxRecordRepository;

    @Autowired
    public DialysisServiceImpl(DialysisRepository dialysisRepository, CurrentTxRecordRepository currentTxRecordRepository){
        this.dialysisRepository = dialysisRepository;
        this.currentTxRecordRepository = currentTxRecordRepository;
    }

    @Override
    public DialysisTreatmentRecord getRecord(int patientId) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate currentDate = LocalDate.now();
        dateTimeFormatter.format(currentDate);
        String currentDateString = currentDate.toString();

        return dialysisRepository.findDialysisTreatmentRecord(patientId, currentDateString);
    }


    @Override
    public List<DialysisTreatmentRecord> getRecords(String firstName, String lastName, int patientId) {

        return dialysisRepository.findDialysisTreatmentRecords(firstName, lastName, patientId);
    }

    @Override
    public List<CurrentTreatmentRecord> getCurrentRecords(int dialysisRecordId) {
        return currentTxRecordRepository.getCurrentTreatmentRecords(dialysisRecordId);
    }

    @Override
    public CurrentTreatmentRecord getCurrentRecord(int treatmentId) {
        return currentTxRecordRepository.getOne(treatmentId);
    }

    @Override
    public void saveRecord(DialysisTreatmentRecord dialysisTreatmentRecord) {
        dialysisRepository.save(dialysisTreatmentRecord);
    }

    @Override
    public void saveTx(CurrentTreatmentRecord currentTreatmentRecord) {
        currentTxRecordRepository.save(currentTreatmentRecord);
    }
}
