package com.apps.medConnect.controller;

import com.apps.medConnect.Repository.PatientRepo;
import com.apps.medConnect.entity.DoctorData;
import com.apps.medConnect.Repository.DoctorRepo;
import com.apps.medConnect.entity.PatientEntity;
import com.apps.medConnect.exception.MedicException;
import com.apps.medConnect.model.DoctorRequest;
import com.apps.medConnect.model.MedicResponse;
import com.apps.medConnect.model.PatientRequest;
import com.apps.medConnect.service.MedicSuggestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/medConnect/")
@RestController
public class DoctorController {
    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    PatientRepo patientRepo;
    @Autowired
    MedicSuggestionService medicSuggestionService;

    @PostMapping("register/doctor")
    public String registerDoctor(@Valid @RequestBody DoctorRequest doctorRequest) {
        try {
            DoctorData doctorData = new DoctorData();
            doctorData.setDocName(doctorRequest.getDocName());
            doctorData.setDocCity(doctorRequest.getDocCity());
            doctorData.setDocEmail(doctorRequest.getDocEmail());
            doctorData.setDocMobileNumber(doctorRequest.getDocMobileNumber());
            doctorData.setSpeciality(doctorRequest.getSpeciality());
            doctorRepo.save(doctorData);
            return "Doctor registered successfully !!";
        } catch (Exception e) {
            throw new MedicException(e.getMessage());
        }
    }

    @PostMapping("register/patient")
    public String registerPatient(@Valid @RequestBody PatientRequest patientRequest) {
        try {
            PatientEntity patientEntity = new PatientEntity();
            patientEntity.setPatientName(patientRequest.getPatientName());
            patientEntity.setPatientCity(patientRequest.getPatientCity());
            patientEntity.setPatientEmail(patientRequest.getPatientEmail());
            patientEntity.setPatientMobileNumber(patientRequest.getPatientMobileNumber());
            patientEntity.setSymptom(patientRequest.getSymptom());
            patientRepo.save(patientEntity);
            return "Patient registered successfully !!";
        } catch (Exception e) {
            System.out.println("Exception occurred " + e.getMessage());
            return "";
        }
    }

    @DeleteMapping("delete/{docId}")
    public ResponseEntity<String> deleteDoc(@PathVariable int docId) {

        if (doctorRepo.existsById(docId)) {
            doctorRepo.deleteById(docId);
            return ResponseEntity.ok("Doctor with ID " + docId + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor with ID " + docId + " not found");
        }

    }

    @DeleteMapping("patient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId) {
        if (patientRepo.existsById(patientId)) {
            patientRepo.deleteById(patientId);
            return ResponseEntity.ok("Patient with ID " + patientId + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID " + patientId + " not found");
        }
    }

    @GetMapping("availableDoctors/{patientId}")
    public ResponseEntity<?> suggestedDoctor(@PathVariable int patientId) {

        MedicResponse medicResponse = new MedicResponse();
            if(!patientRepo.existsById(patientId)){
                throw new MedicException("Patient with id "+ patientId +" does not exist.");
            }
            String symptom = patientRepo.patientSymptom(patientId);
            String patientCity = patientRepo.patientCity(patientId);

            List<DoctorData> drDataList = medicSuggestionService.listOfDoctor(symptom,patientCity);
        if (!(patientCity.equalsIgnoreCase("Delhi") || patientCity.equalsIgnoreCase("Faridabad") || patientCity.equalsIgnoreCase("Noida"))) {
            medicResponse.setMessage("We are still waiting to expand to your location.");
            return new ResponseEntity<>(medicResponse, HttpStatus.OK);
        }
            if (drDataList.size() == 0) {
                medicResponse.setMessage("There isn’t any doctor present at your location for your symptom.");
                return new ResponseEntity<>(medicResponse, HttpStatus.OK);
            }
            medicResponse.setMessage("We care about your well-being! Here is a list of dedicated and skilled doctors available in your area to address your health needs !!");
            medicResponse.setDoctorDataList(medicSuggestionService.listOfDoctor(symptom,patientCity));
            return new ResponseEntity<>(medicResponse, HttpStatus.OK);


    }
}
