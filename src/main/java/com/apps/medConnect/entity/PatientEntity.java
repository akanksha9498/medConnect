package com.apps.medConnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import java.util.List;

@Entity
public class PatientEntity {
    @Id
    @GeneratedValue
    private int patientId;
    private String patientName;
    private String patientEmail;
    private String patientMobileNumber;
    private String patientCity;
    private String symptom;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientMobileNumber() {
        return patientMobileNumber;
    }

    public void setPatientMobileNumber(String patientMobileNumber) {
        this.patientMobileNumber = patientMobileNumber;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    @Override
    public String toString() {
        return "PatientRequest{" +
                "patientName='" + patientName + '\'' +
                ", patientEmail='" + patientEmail + '\'' +
                ", patientMobileNumber='" + patientMobileNumber + '\'' +
                ", patientCity='" + patientCity + '\'' +
                ", symptoms=" + symptom +
                '}';
    }
}
