package com.rosalex.springboot.pttracker.service;


import com.rosalex.springboot.pttracker.entity.QAIRecord;

import java.util.List;

public interface QAIService {

    List<QAIRecord> getQaiRecords(int patientId);

    void deleteQaiRecord(int qaiRecordId);

}
