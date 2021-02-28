package com.rosalex.pttracker.service;

import com.rosalex.pttracker.entity.CurrentTreatmentRecord;
import com.rosalex.pttracker.entity.DialysisTreatmentRecord;

import java.util.List;

public interface DialysisService {

     DialysisTreatmentRecord getRecord(int patientId);

     List<CurrentTreatmentRecord> getCurrentRecords(int dialysisRecordId);

     void saveRecord(DialysisTreatmentRecord dialysisTreatmentRecord);

     void saveTx(CurrentTreatmentRecord currentTreatmentRecord);

     CurrentTreatmentRecord getCurrentRecord(int treatmentId);

     List<DialysisTreatmentRecord> getRecords(String firstName, String lastName, int patientId);
}
