package com.example.demo.exception;

public class PatientNotFoundExcetion extends RuntimeException {
    public PatientNotFoundExcetion(String id) {
        super(id);
    }
}
