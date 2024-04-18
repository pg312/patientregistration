package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

import java.text.DateFormat;
import java.util.Date;
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
    @NotBlank
    private Date dateOfBirth;

    @Column
    private String emailId;
}
