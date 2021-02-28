package com.rosalex.pttracker.service;

import com.rosalex.pttracker.repository.QAIRepository;
import com.rosalex.pttracker.entity.QAIRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QAIServiceImpl implements QAIService {

    QAIRepository qaiRepository;

    @Autowired
    public QAIServiceImpl(QAIRepository qaiRepository){
        this.qaiRepository = qaiRepository;
    }

    @Override
    public List<QAIRecord> getQaiRecords(int patientId) {
        return qaiRepository.getAllQaiRecords(patientId);
    }

    @Override
    public void deleteQaiRecord(int qaiRecordId) {

        QAIRecord qaiRecord = qaiRepository.getOne(qaiRecordId);
        qaiRepository.delete(qaiRecord);
    }
}
