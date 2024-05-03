package com.example.demo.controller;


import com.example.demo.exception.PatientNotFoundExcetion;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ExceptionHandler(PatientNotFoundExcetion.class)
    public ResponseEntity<ErrorResponse> handlePatientNotFoundException(PatientNotFoundExcetion ne){
        return new ResponseEntity<>(ErrorResponse.create(ne,HttpStatus.NOT_FOUND,ne.getMessage()),
          HttpStatus.NOT_FOUND);
    }
}
