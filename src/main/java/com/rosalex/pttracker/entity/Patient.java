package com.rosalex.pttracker.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="patient")

public class Patient {

    // fields

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="patient_id")
    private Integer patientId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="date_of_birth")
    private String dateOfBirth;

    @OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY,
    mappedBy = "patient")
    private List<DialysisTreatmentRecord> dialysisTreatmentRecord;

    @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY,
            mappedBy = "patient")
    private List<QAIRecord> qaiRecords;

    // constructors

    public Patient(int id, int patientId, String firstName, String lastName, String dateOfBirth) {
        this.id = id;
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient() {}

    // setter & getter methods


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public List<DialysisTreatmentRecord> getDialysisTreatmentRecord() {
        return dialysisTreatmentRecord;
    }

    public void setDialysisTreatmentRecord(List<DialysisTreatmentRecord> dialysisTreatmentRecord) {
        this.dialysisTreatmentRecord = dialysisTreatmentRecord;
    }


}
