package com.apps.medConnect.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class DoctorRequest {
    private int docId;
    @NotEmpty
    @Size(min = 3, message = "name must be of atleast 3 characters")
    private String docName;

    private City docCity;
    @Email(message = "email must be a valid type")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$", message = "Invalid email format")
    private String docEmail;
    @NotEmpty
    @Size(max = 10, message = "mobile number must be of 10 characters")
    @Pattern(regexp = "^[1-9][0-9]*$", message = "Invalid phone number format")
    private String docMobileNumber;
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
        this.docCity = City.fromString(String.valueOf(docCity));
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

    @Override
    public String toString() {
        return "DoctorRequest{" +
                "docId=" + docId +
                ", docName='" + docName + '\'' +
                ", docCity='" + docCity + '\'' +
                ", docEmail='" + docEmail + '\'' +
                ", docMobileNumber='" + docMobileNumber + '\'' +
                ", speciality='" + speciality + '\'' +
                '}';
    }
}
