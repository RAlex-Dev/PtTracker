package com.rosalex.springboot.pttracker.entity;

import javax.persistence.*;

@Entity
@Table(name="current_treatment_record")
public class CurrentTreatmentRecord {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="bp")
    private int bp;

    @Column(name="time")
    private String time;

    @Column(name="notes")
    private String notes;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH} )
    @JoinColumn(name="dialysis_treatment_id")
    private DialysisTreatmentRecord dialysisTreatmentRecord;


    public CurrentTreatmentRecord(){};

    public CurrentTreatmentRecord(int id, int bp, String time, String notes, DialysisTreatmentRecord dialysisTreatmentRecord) {
        this.id = id;
        this.bp = bp;
        this.time = time;
        this.notes = notes;
        this.dialysisTreatmentRecord = dialysisTreatmentRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public DialysisTreatmentRecord getDialysisTreatmentRecord() {
        return dialysisTreatmentRecord;
    }

    public void setDialysisTreatmentRecord(DialysisTreatmentRecord dialysisTreatmentRecord) {
        this.dialysisTreatmentRecord = dialysisTreatmentRecord;
    }

}


