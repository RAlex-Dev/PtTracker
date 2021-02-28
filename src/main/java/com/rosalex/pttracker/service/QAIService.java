package com.rosalex.pttracker.service;


import com.rosalex.pttracker.entity.QAIRecord;

import java.util.List;

public interface QAIService {

    List<QAIRecord> getQaiRecords(int patientId);

    void deleteQaiRecord(int qaiRecordId);

}
