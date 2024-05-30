package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatientResponse {


    private String identifier;

    private String firstName;

    private String middleName;

    private String lastName;

    private String mobileNumber;

    private int age;

    private String emailId;

    private Address address;

}
