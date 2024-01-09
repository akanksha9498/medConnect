package com.apps.medConnect.Repository;

import com.apps.medConnect.entity.DoctorData;
import com.apps.medConnect.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<PatientEntity,Integer> {

    @Query(value="Select symptom from Patient_Entity Where patient_id=:id", nativeQuery = true)
    public String patientSymptom(@Param("id") int id);

    @Query(value="Select patient_City from Patient_Entity where patient_id=:id", nativeQuery = true)
    public String patientCity(@Param("id") int id);

}
