package com.rosalex.springboot.pttracker.repository;

import com.rosalex.springboot.pttracker.entity.QAIRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface QAIRepository extends JpaRepository<QAIRecord, Integer> {


    @Query("FROM QAIRecord r where r.patient.id = :patientId")
    List<QAIRecord> getAllQaiRecords(@RequestParam("patientId") Integer patientId);
}
