package com.example.demo.helper;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PatientHelper {

    public static PatientResponse convert(Patient patient){

        return PatientResponse.builder()
                .identifier(patient.getIdentifier().getPatientId())
                .firstName(patient.getFirstName())
                .middleName(patient.getMiddleName())
                .lastName(patient.getLastName())
                .mobileNumber(patient.getMobileNumber())
                .age(calculateAge(patient.getDateOfBirth()))
                .emailId(patient.getEmailId())
                .address(patient.getAddress())
                .build();

    }

    private static int calculateAge(LocalDate dateOfBirth){
        return dateOfBirth == null? 0: LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public static List<PatientResponse> convert(List<Patient> patients) {
        return patients.stream().map(PatientHelper::convert).collect(Collectors.toList());
    }
}
