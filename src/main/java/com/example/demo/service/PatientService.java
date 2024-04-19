package com.example.demo.service;


import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    private static void run() {
        throw new NullPointerException();
    }

    public Patient savePatient(Patient patient) {
       return patientRepository.save(patient);

    }

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient findById(String id) {
        return patientRepository.findById(UUID.fromString(id)).orElseThrow(() -> new NoSuchElementException(id));
    }
}
