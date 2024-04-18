package com.example.demo.service;


import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient savePatient(Patient patient) {
       return patientRepository.save(patient);

    }

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }
}
