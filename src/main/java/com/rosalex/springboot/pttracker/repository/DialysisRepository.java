package com.rosalex.springboot.pttracker.repository;

import com.rosalex.springboot.pttracker.entity.DialysisTreatmentRecord;
import com.rosalex.springboot.pttracker.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DialysisRepository extends JpaRepository<DialysisTreatmentRecord, Integer> {

@Query("FROM DialysisTreatmentRecord r where r.patient.id = :patientId AND r.date = :currentDate")
DialysisTreatmentRecord findDialysisTreatmentRecord(@Param("patientId") int patientId, @Param("currentDate") String currentDate);

@Query("FROM DialysisTreatmentRecord r where r.patient.firstName = :firstName AND r.patient.lastName = :lastName AND r.patient.patientId = :patientId")
List<DialysisTreatmentRecord> findDialysisTreatmentRecords(@Param("firstName") String firstName,
                                                           @Param("lastName") String lastName, @Param("patientId") int patientId);
}
