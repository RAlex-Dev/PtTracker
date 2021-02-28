package com.rosalex.pttracker.entity;

import javax.persistence.*;
import java.time.Month;

@Entity
@Table(name="qai_record")
public class QAIRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "albumin")
    private Double albumin;

    @Column(name = "creatinine")
    private Double creatinine;

    @Column(name = "enPCR")
    private Double enPCR;

    @Column(name = "phosphorus")
    private Double phosphorus;

    @Column(name = "IDWG")
    private Double IDWG;

    @Column(name="hemoglobin")
    private Double hemoglobin;

    @Column(name="month")
    private Month month;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH} )
    @JoinColumn (name = "patient_id")
    private Patient patient;

    public QAIRecord() {}

    public QAIRecord(int id, Double albumin, Double creatinine, Double enPCR, Double phosphorus,
                     Double IDWG, Double hemoglobin, Patient patient) {
        this.id = id;
        this.albumin = albumin;
        this.creatinine = creatinine;
        this.enPCR = enPCR;
        this.phosphorus = phosphorus;
        this.IDWG = IDWG;
        this.hemoglobin = hemoglobin;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Double getAlbumin() {
        return albumin;
    }

    public void setAlbumin(Double albumin) {
        this.albumin = albumin;
    }

    public Double getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(Double creatinine) {
        this.creatinine = creatinine;
    }

    public Double getEnPCR() {
        return enPCR;
    }

    public void setEnPCR(Double enPCR) {
        this.enPCR = enPCR;
    }

    public Double getPhosphorus() {
        return phosphorus;
    }

    public void setPhosphorus(Double phosphorus) {
        this.phosphorus = phosphorus;
    }

    public Double getIDWG() {
        return IDWG;
    }

    public void setIDWG(Double IDWG) {
        this.IDWG = IDWG;
    }

    public Double getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(Double hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "QAIRecord{" +
                "id=" + id +
                ", albumin=" + albumin +
                ", creatinine=" + creatinine +
                ", enPCR=" + enPCR +
                ", phosphorus=" + phosphorus +
                ", IDWG=" + IDWG +
                ", hemoglobin=" + hemoglobin +
                ", patient=" + patient +
                '}';
    }
}
