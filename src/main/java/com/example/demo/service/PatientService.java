package com.example.demo.service;


import com.example.demo.exception.PatientNotFoundExcetion;
import com.example.demo.model.Identifier;
import com.example.demo.model.Patient;
import com.example.demo.repository.IdentifierRepository;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    IdentifierRepository identifierRepository;

    private static void run() {
        throw new NullPointerException();
    }

    public Patient savePatient(Patient patient) {
        Identifier identifier = saveIdentifier();
        patient.setIdentifier(identifier);
        if(patient.getUuid() == null)
            patient.setCreatedAt(LocalDateTime.now());
        else
            patient.setUpdatedAt(LocalDateTime.now()
            );
       return patientRepository.save(patient);
    }

    private Identifier saveIdentifier() {
        Identifier identifier = new Identifier();
        identifierRepository.save(identifier);
        identifier.setPatientId("PAT"+identifier.getId());
        identifierRepository.save(identifier);
        return identifier;
    }

    public List<Patient> getAllPatients() {
        return (List<Patient>) patientRepository.findAll();
    }

    public Patient findById(String id) {
        return patientRepository.findById(UUID.fromString(id)).orElseThrow(() -> new PatientNotFoundExcetion("Patient Not Found "+id));
    }

    public List<Patient> findByName(String name) {
        return patientRepository.findByName(name, Sort.by("firstName"));
    }
}
