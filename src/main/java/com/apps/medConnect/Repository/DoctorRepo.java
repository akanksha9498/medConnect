package com.apps.medConnect.Repository;

import com.apps.medConnect.entity.DoctorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface DoctorRepo extends JpaRepository<DoctorData,Integer> {
    @Query(value="select * from doctor_data where speciality=:speciality and doc_city=:city", nativeQuery = true)
    List<DoctorData> doctorAvailable(@Param("speciality") String speciality,@Param("city") String city);
}
