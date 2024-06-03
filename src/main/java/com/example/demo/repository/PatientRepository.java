package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, UUID>, CrudRepository<Patient,UUID> {


    @Query(value = "Select p from Patient p where p.firstName LIKE %:name% OR p.middleName LIKE %:name% OR p.lastName LIKE %:name%")
    List<Patient> findByName(@Param("name")String name, Sort sort);

    @Query(value = "Select p from Patient p INNER JOIN p.identifier i where i.patientId LIKE %:patientId%")
    List<Patient> findByPatientId(@Param("patientId") String patientId);

}