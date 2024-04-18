package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;

    @Column
    private String mobileNumber;

    @Column
    private String emailId;

}
