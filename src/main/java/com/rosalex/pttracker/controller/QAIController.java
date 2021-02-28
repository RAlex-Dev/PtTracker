package com.rosalex.pttracker.controller;

import com.rosalex.pttracker.Utilities;
import com.rosalex.pttracker.entity.Patient;
import com.rosalex.pttracker.entity.QAIRecord;
import com.rosalex.pttracker.service.PatientService;
import com.rosalex.pttracker.service.QAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("api/qai")
public class QAIController {

    QAIService qaiService;
    PatientService patientService;

    @Autowired
    public QAIController(QAIService qaiService, PatientService patientService) {
        this.qaiService = qaiService;
        this.patientService = patientService;
    }

    // show patient's qai record

    @GetMapping("/show-qai-list")
    public String showQaiRecords(@RequestParam("patientId") int patientId, Model model) {

        Patient patient = patientService.findById(patientId);

        List<QAIRecord> qaiRecordList = qaiService.getQaiRecords(patientId);
        model.addAttribute("qaiRecordList", qaiRecordList);
        model.addAttribute("patient", patient);


        return "list-qai-records";
    }

    @GetMapping("/show-patient-list")
    public String showPatientsForQai(Model model) {

        List<Patient> patients = patientService.findAll();

        model.addAttribute("patients", patients);


        return "list-patients-qai";
    }

    @GetMapping("/nutri-graph")
    public String getPieChart(@RequestParam("patientId") int patientId, @RequestParam("variable") String variable, Model model) {

        Patient patient = patientService.findById(patientId);
        List<QAIRecord> qaiRecords = qaiService.getQaiRecords(patient.getId());

        Utilities utilities = new Utilities();

        Map<Integer, Double> graphData;

        graphData = utilities.getVariable(qaiRecords, variable);

        model.addAttribute("graphData", graphData);
        model.addAttribute("patient", patient);

        return "google-charts";
    }

    @GetMapping("/deleteQaiRecord")
    public String deleteQaiRecord(@RequestParam("qaiRecordId") int qaiRecordId, @RequestParam("patientId") int patientId,
                                  Model model){
        qaiService.deleteQaiRecord(qaiRecordId);

        Patient patient = patientService.findById(patientId);

        List<QAIRecord> qaiRecordList = qaiService.getQaiRecords(patientId);
        model.addAttribute("qaiRecordList", qaiRecordList);
        model.addAttribute("patient", patient);


        return "redirect:/api/qai/show-qai-list?patientId=" + patientId;
    }

 /*   @PostMapping
    public String sendVariable(@ModelAttribute("patient") Patient patient, @RequestParam("patient") Patient patient){

    }*/
}
