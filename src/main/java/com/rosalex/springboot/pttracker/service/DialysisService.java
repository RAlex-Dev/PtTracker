package com.rosalex.springboot.pttracker.service;

import com.rosalex.springboot.pttracker.entity.CurrentTreatmentRecord;
import com.rosalex.springboot.pttracker.entity.DialysisTreatmentRecord;
import com.rosalex.springboot.pttracker.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DialysisService {

     DialysisTreatmentRecord getRecord(int patientId);

     List<CurrentTreatmentRecord> getCurrentRecords(int dialysisRecordId);

     void saveRecord(DialysisTreatmentRecord dialysisTreatmentRecord);

     void saveTx(CurrentTreatmentRecord currentTreatmentRecord);

     CurrentTreatmentRecord getCurrentRecord(int treatmentId);

     List<DialysisTreatmentRecord> getRecords(String firstName, String lastName, int patientId);
}
