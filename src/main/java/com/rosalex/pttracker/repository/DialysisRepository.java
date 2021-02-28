package com.rosalex.pttracker.repository;

import com.rosalex.pttracker.entity.DialysisTreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialysisRepository extends JpaRepository<DialysisTreatmentRecord, Integer> {

@Query("FROM DialysisTreatmentRecord r where r.patient.id = :patientId AND r.date = :currentDateString")
DialysisTreatmentRecord findDialysisTreatmentRecord(@Param("patientId") Integer patientId, @Param("currentDateString") String currentDateString);

@Query("FROM DialysisTreatmentRecord r where r.patient.firstName = :firstName AND r.patient.lastName = :lastName AND r.patient.patientId = :patientId")
List<DialysisTreatmentRecord> findDialysisTreatmentRecords(@Param("firstName") String firstName,
                                                           @Param("lastName") String lastName, @Param("patientId") Integer patientId);
}
