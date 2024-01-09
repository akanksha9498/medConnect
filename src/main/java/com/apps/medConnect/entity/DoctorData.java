package com.apps.medConnect.entity;

import com.apps.medConnect.model.City;
import com.apps.medConnect.model.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;

@Entity
public class DoctorData {
    @Id
    @GeneratedValue
    @JsonIgnore
    private int docId;
    private String docName;
    @Enumerated(EnumType.STRING)
    private City docCity;
    private String docEmail;
    private String docMobileNumber;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public City getDocCity() {
        return docCity;
    }

    public void setDocCity(City docCity) {
        this.docCity = docCity;
    }

    public String getDocEmail() {
        return docEmail;
    }

    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }

    public String getDocMobileNumber() {
        return docMobileNumber;
    }

    public void setDocMobileNumber(String docMobileNumber) {
        this.docMobileNumber = docMobileNumber;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
