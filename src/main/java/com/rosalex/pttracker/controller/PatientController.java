package com.rosalex.pttracker.controller;

import com.rosalex.pttracker.entity.Patient;
import com.rosalex.pttracker.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/api")
public class PatientController {

    private PatientService patientService;

    @Autowired
    public void PatientService(PatientService patientService){
        this.patientService = patientService;
    }

    @GetMapping("/list")
    public String getPatients(Model theModel){

        List<Patient> patients = patientService.findAll();
        theModel.addAttribute("patients", patients);

        return "list-patients";
    }

    @GetMapping("/dialysis")
    public String getDialysisForm(Model theModel){

        List<Patient> patients = patientService.findAll();
        theModel.addAttribute("patients", patients);

        return "dialysis-form";
    }

    @GetMapping("/show-form")
    public String showPageForPatient(Model theModel){

        Patient patient = new Patient();

        theModel.addAttribute("patient", patient);

        return "patient-form";
    }

    @PostMapping("/save")
    public String savePatient(@ModelAttribute("patient") Patient patient){

        Random random = new Random();
        int id = random.nextInt(1000000000);
        patient.setPatientId(id);
        patientService.save(patient);

        return "redirect:/api/list";
    }

    @GetMapping("/update")
    public String updatePatient(@RequestParam("patientId") int id, Model model){

        Patient patient = patientService.findById(id);

        model.addAttribute("patient", patient);

        return "patient-form";
    }

    @GetMapping ("/delete")
    public String deletePatient(@RequestParam("patientId") int patientId){

        patientService.deleteById(patientId);

        return "redirect:/api/list";
    }

}
