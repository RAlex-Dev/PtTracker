package com.rosalex.pttracker.controller;

import com.rosalex.pttracker.entity.Patient;
import com.rosalex.pttracker.service.PatientService;
import com.rosalex.pttracker.entity.CurrentTreatmentRecord;
import com.rosalex.pttracker.entity.DialysisTreatmentRecord;
import com.rosalex.pttracker.service.DialysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/api/record")
public class DialysisController {

    private DialysisService dialysisService;
    private PatientService patientService;

    @Autowired
    public DialysisController(DialysisService dialysisService, PatientService patientService){
        this.dialysisService = dialysisService;
        this.patientService = patientService;
    }

    // return dialysis treatment form for pre, current, and post dialysis data

    @GetMapping("/form")
    public String getDialysisForm(@RequestParam("patientId") int patientId, Model model){

        DialysisTreatmentRecord dialysisTreatmentRecord = dialysisService.getRecord(patientId);

        // handle new patients without any tx data by creating a new dialysis tx record

        if(dialysisTreatmentRecord == null){
            Patient patient = patientService.findById(patientId);
            dialysisTreatmentRecord = new DialysisTreatmentRecord();
            dialysisTreatmentRecord.setPatient(patient);

            // set Date only, based on system settings

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate currentDate = LocalDate.now();
            currentDate.getMonth();
            dateTimeFormatter.format(currentDate);
            String currentDateString = currentDate.toString();
            dialysisTreatmentRecord.setDate(currentDateString);
        }

        dialysisTreatmentRecord.setCurrentTreatmentDataList(dialysisService.getCurrentRecords(dialysisTreatmentRecord.getId()));

        model.addAttribute("dialysisTreatmentRecord", dialysisTreatmentRecord);
        model.addAttribute("patientId", patientId);

        return "dialysis-form";
    }

    // return treatment form for new record or record update

    @GetMapping("/tx-form-new")
    public String getTreatmentForm(@RequestParam("parameter1") int currentTreatmentId,
                                   @RequestParam("parameter2") int patientId, Model model){

        CurrentTreatmentRecord currentTreatmentRecord;

        // handle new treatments if no treatment rows exist in table

        if(currentTreatmentId == -1){
            currentTreatmentRecord = new CurrentTreatmentRecord();
        } else {
            currentTreatmentRecord = dialysisService.getCurrentRecord(currentTreatmentId);
        }

        DialysisTreatmentRecord dialysisTreatmentRecord = dialysisService.getRecord(patientId);

        if(dialysisTreatmentRecord == null){
            Patient patient = patientService.findById(patientId);
            dialysisTreatmentRecord = new DialysisTreatmentRecord();
            dialysisTreatmentRecord.setPatient(patient);
        }

        currentTreatmentRecord.setDialysisTreatmentRecord(dialysisTreatmentRecord);
    //    dialysisService.saveTx(currentTreatmentRecord);
        dialysisTreatmentRecord.setCurrentTreatmentDataList(dialysisService.getCurrentRecords(dialysisTreatmentRecord.getId()));

        // set time based on system settings
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime currentDateTime = LocalDateTime.now();
        dateTimeFormatter.format(currentDateTime);
        String currentDateTimeString = currentDateTime.toString();

        currentTreatmentRecord.setTime(currentDateTimeString);

        model.addAttribute("currentTreatmentRecord", currentTreatmentRecord);
        model.addAttribute("patientId", patientId);

    //    model.addAttribute("patientId", patientId);

        return "treatment-form";
    }

    @PostMapping("/save-pre")
    public String savePreTreatmentData(@ModelAttribute("dialysisTreatmentRecord") DialysisTreatmentRecord dialysisTreatmentRecord,
                                       @RequestParam("parameter") int patientId, Model model){

        dialysisService.saveRecord(dialysisTreatmentRecord);

        model.addAttribute("dialysisTreatmentRecord", dialysisTreatmentRecord);
        dialysisTreatmentRecord.setCurrentTreatmentDataList(dialysisService.getCurrentRecords(dialysisTreatmentRecord.getId()));
        model.addAttribute("patientId", patientId);

        return "dialysis-form";
    }


    @PostMapping("/saveTx")
    public String saveTx(@ModelAttribute("currentTreatmentRecord") CurrentTreatmentRecord currentTreatmentRecord,
                         @RequestParam("parameter") int patientId, Model model){

        DialysisTreatmentRecord dialysisTreatmentRecord = dialysisService.getRecord(patientId);

        if(dialysisTreatmentRecord == null){
            dialysisTreatmentRecord = new DialysisTreatmentRecord();
        }
        System.out.println(patientId);
        currentTreatmentRecord.setDialysisTreatmentRecord(dialysisTreatmentRecord);
        dialysisService.saveTx(currentTreatmentRecord);


        // handle new patients without any tx data by creating a new dialysis tx record

        if(dialysisTreatmentRecord == null){
            Patient patient = patientService.findById(patientId);
            dialysisTreatmentRecord = new DialysisTreatmentRecord();
            dialysisTreatmentRecord.setPatient(patient);
        }

        model.addAttribute("dialysisTreatmentRecord", dialysisTreatmentRecord);
        model.addAttribute("patientId", patientId);

        return "redirect:/api/record/form?patientId=" + patientId;
    }

    @PostMapping("/save-post")
    public String savePostTreatmentData(@ModelAttribute("dialysisTreatmentRecord") DialysisTreatmentRecord dialysisTreatmentRecord,
                                        @RequestParam("parameter") int patientId, Model model){

        dialysisService.saveRecord(dialysisTreatmentRecord);

        model.addAttribute("dialysisTreatmentRecord", dialysisTreatmentRecord);
        dialysisTreatmentRecord.setCurrentTreatmentDataList(dialysisService.getCurrentRecords(dialysisTreatmentRecord.getId()));
        model.addAttribute("patientId", patientId);

        return "dialysis-form";
    }

    @GetMapping("/search-dialysis-page")
    public String searchDialysisRecords(Model model){

        Patient patient = new Patient();

        model.addAttribute("patient", patient);

        return "search-dialysis-page";
    }

    @PostMapping("/search")
    public String getAllRecords(@ModelAttribute("patient") Patient patient, Model model){

        List<DialysisTreatmentRecord> dialysisTreatmentRecords =
        dialysisService.getRecords(patient.getFirstName(), patient.getLastName(), patient.getPatientId());

        if(dialysisTreatmentRecords == null){
            // throw exception here
        }

        return "redirect:/api/record/all-dialysis-treatments?patientId=" + dialysisTreatmentRecords.get(0).getPatient().getId();

    }

    @GetMapping("/all-dialysis-treatments")
    public String displayAllDialysisRecords(@RequestParam("patientId") int id, Model model){

        Patient patient = patientService.findById(id);

        List<DialysisTreatmentRecord> dialysisTreatmentRecords =
                dialysisService.getRecords(patient.getFirstName(), patient.getLastName(), patient.getPatientId());

        model.addAttribute("dialysisTreatmentRecords", dialysisTreatmentRecords);
        model.addAttribute("patient", patient);


        return "/list-all-dialysis-tx";
    }

    @GetMapping("/all-daily-treatments")
    public String displayAllDailyTreatment(@RequestParam("dialysisTreatmentRecordId") int dialysisTreatmentRecordId, @RequestParam("patientId") int id, Model model){

        dialysisService.getRecord(dialysisTreatmentRecordId);
        Patient patient = patientService.findById(id);

        List<CurrentTreatmentRecord> currentTreatmentRecordList = dialysisService.getCurrentRecords(dialysisTreatmentRecordId);

        model.addAttribute("currentTreatmentRecordList", currentTreatmentRecordList);
        model.addAttribute("patient", patient);

        return "list-all-daily-tx";
    }

}
