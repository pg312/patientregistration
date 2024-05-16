package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class StaffDto implements Serializable {

    @Column
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String roles;
}
