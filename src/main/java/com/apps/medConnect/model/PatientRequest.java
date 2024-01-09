package com.apps.medConnect.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PatientRequest {
    @NotEmpty
    @Size(min = 3, message = "name must be of atleast 3 characters")
private String patientName;
    @Email(message = "email must be a valid type")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid email format")
private String patientEmail;
    @NotEmpty
    @Size(max = 10, message = "phone number must be of 10 digits")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Invalid phone number format")
private String patientMobileNumber;
    @NotEmpty
    @Size(max = 20, message = "city name must be of atmost 20 characters")
private String patientCity;
    @Pattern(regexp = "^(Arthritis|Back Pain|Tissue injuries|Dysmenorrhea|skin infection|skin burn|Ear pain)$", message = "Invalid symptom value. Only [Arthritis, Back Pain, Tissue injuries, Dysmenorrhea, Skin infection, Skin burn, Ear pain] can be treated.")
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

    public void setSymptom(String symptoms) {
        this.symptom = symptoms;
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
