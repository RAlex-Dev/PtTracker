package com.rosalex.pttracker.repository;

import com.rosalex.pttracker.entity.CurrentTreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrentTxRecordRepository extends JpaRepository<CurrentTreatmentRecord, Integer> {

    @Query("FROM CurrentTreatmentRecord r where r.dialysisTreatmentRecord.id = :dialysisRecordId")
    List<CurrentTreatmentRecord> getCurrentTreatmentRecords(@Param("dialysisRecordId") int dialysisRecordId);

}
