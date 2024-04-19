package com.example.demo.controller;


import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient){
        Patient savedPatient = patientService.savePatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getAllPatients(){
        List<Patient> allPatients = patientService.getAllPatients();
        return new ResponseEntity<>(allPatients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id){
        Patient patient = patientService.findById(id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @ExceptionHandler(value=NoSuchElementException.class)
    public ResponseEntity handleNoSuchElementException(NoSuchElementException ne){
        System.out.println("No patient found "+ ne.getMessage());
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }
}
