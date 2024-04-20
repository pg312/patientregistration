package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank
    private String streetNumber;

    @Column
    @NotBlank
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    @OneToOne
    @JsonIgnore
    private Patient patient;
}
