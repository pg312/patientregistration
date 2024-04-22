package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column
    @NotBlank(message = "First name can't be null or blank")
    private String firstName;

    @Column
    private String middleName;

    @Column
    @NotBlank(message = "Last name can't be null or blank")
    private String lastName;

    @Column
    @NotBlank
    @Size(min=10, max=10)
    private String mobileNumber;

    @Column
    @Past
    @NotNull
    private LocalDate dateOfBirth;

    @Column
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    @NotNull
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Identifier identifier;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;
}
