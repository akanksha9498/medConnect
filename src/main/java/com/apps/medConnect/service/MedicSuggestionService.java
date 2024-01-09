package com.apps.medConnect.service;

import com.apps.medConnect.Repository.DoctorRepo;
import com.apps.medConnect.entity.DoctorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedicSuggestionService {
    @Autowired
    DoctorRepo doctorRepo;

    public List<DoctorData> listOfDoctor(String symptom, String patientCity) {
        Map<String, List<String>> specialtySymptomsMap = new HashMap<>();
        List<String> orthopedicSymptoms = new ArrayList<>();
        orthopedicSymptoms.add("Arthritis");
        orthopedicSymptoms.add("Back Pain");
        orthopedicSymptoms.add("Tissue injuries");
        specialtySymptomsMap.put("Orthopedic", orthopedicSymptoms);


        List<String> gynecologySymptoms = new ArrayList<>();
        gynecologySymptoms.add("Dysmenorrhea");
        specialtySymptomsMap.put("Gynecology", gynecologySymptoms);


        List<String> dermatologySymptoms = new ArrayList<>();
        dermatologySymptoms.add("Skin infection");
        dermatologySymptoms.add("Skin burn");
        specialtySymptomsMap.put("Dermatology", dermatologySymptoms);


        List<String> entSymptoms = new ArrayList<>();
        entSymptoms.add("Ear pain");
        specialtySymptomsMap.put("ENT", entSymptoms);
        String speciality = "";


        for (Map.Entry<String, List<String>> entry : specialtySymptomsMap.entrySet()) {
            for(int i=0; i<entry.getValue().size(); i++) {
                if (symptom.equalsIgnoreCase(entry.getValue().get(i))) {
                     speciality = entry.getKey();
                    break;
                }
            }
        }
        List<DoctorData> doctorEntity = doctorRepo.doctorAvailable(speciality,patientCity);
        return doctorEntity;

    }



}
