package com.apps.medConnect.model;

import com.apps.medConnect.entity.DoctorData;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicResponse {
    private String message;
    private List<DoctorData> doctorDataList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DoctorData> getDoctorDataList() {
        return doctorDataList;
    }

    public void setDoctorDataList(List<DoctorData> doctorDataList) {
        this.doctorDataList = doctorDataList;
    }
}
