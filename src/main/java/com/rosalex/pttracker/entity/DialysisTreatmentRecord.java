package com.rosalex.pttracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="dialysis_treatment_record")
public class DialysisTreatmentRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    private String date;

    // Pre treatment variables
    @Column(name="temperature")
    private Double temperature;

    @Column(name="pre_weight")
    private Integer preWeight;

    @Column(name="bp_standing")
    private Integer bpStanding;

    @Column(name="bp_sitting")
    private Integer bpSitting;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "patient_id")
    Patient patient;

    // Ongoing treatment instance
    @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER,
    mappedBy = "dialysisTreatmentRecord")
    private List<CurrentTreatmentRecord> currentTreatmentRecordList;

    // Post treatment variables
    @Column(name="post_weight")
    private Integer postWeight;

    @Column(name="final_sitting_bp")
    private Integer finalSittingBp;

    @Column(name="final_standing_bp")
    private Integer finalStandingBp;

    @Column(name="final_temp")
    private Double finalTemp;

    public DialysisTreatmentRecord() {
    }

    public DialysisTreatmentRecord(int id, String date, Double temperature, Integer preWeight, Integer bpStanding, Integer bpSitting,
                                   List<CurrentTreatmentRecord> currentTreatmentRecordList, Integer postWeight, Integer finalSittingBp,
                                   Integer finalStandingBp, Double finalTemp) {
        this.id = id;
        this.date = date;
        this.temperature = temperature;
        this.preWeight = preWeight;
        this.bpStanding = bpStanding;
        this.bpSitting = bpSitting;
        this.currentTreatmentRecordList = currentTreatmentRecordList;
        this.postWeight = postWeight;
        this.finalSittingBp = finalSittingBp;
        this.finalStandingBp = finalStandingBp;
        this.finalTemp = finalTemp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Integer getPreWeight() {
        return preWeight;
    }

    public void setPreWeight(Integer preWeight) {
        this.preWeight = preWeight;
    }

    public Integer getBpStanding() {
        return bpStanding;
    }

    public void setBpStanding(Integer bpStanding) {
        this.bpStanding = bpStanding;
    }

    public Integer getBpSitting() {
        return bpSitting;
    }

    public void setBpSitting(Integer bpSitting) {
        this.bpSitting = bpSitting;
    }

    public List<CurrentTreatmentRecord> getCurrentTreatmentDataList() {
        return currentTreatmentRecordList;
    }

    public void setCurrentTreatmentDataList(List<CurrentTreatmentRecord> currentTreatmentRecordList) {
        this.currentTreatmentRecordList = currentTreatmentRecordList;
    }

    public Integer getPostWeight() {
        return postWeight;
    }

    public void setPostWeight(Integer postWeight) {
        this.postWeight = postWeight;
    }

    public Integer getFinalSittingBp() {
        return finalSittingBp;
    }

    public void setFinalSittingBp(Integer finalSittingBp) {
        this.finalSittingBp = finalSittingBp;
    }

    public Integer getFinalStandingBp() {
        return finalStandingBp;
    }

    public void setFinalStandingBp(Integer finalStandingBp) {
        this.finalStandingBp = finalStandingBp;
    }

    public Double getFinalTemp() {
        return finalTemp;
    }

    public void setFinalTemp(Double finalTemp) {
        this.finalTemp = finalTemp;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "DialysisTreatmentRecord{" +
                "id=" + id +
                ", date=" + date +
                ", temperature=" + temperature +
                ", preWeight=" + preWeight +
                ", bpStanding='" + bpStanding + '\'' +
                ", bpSitting='" + bpSitting + '\'' +
                ", currentTreatmentDataList=" + currentTreatmentRecordList +
                ", postWeight=" + postWeight +
                ", finalSittingBp='" + finalSittingBp + '\'' +
                ", finalStandingBp='" + finalStandingBp + '\'' +
                ", finalTemp=" + finalTemp +
                '}';
    }

}
