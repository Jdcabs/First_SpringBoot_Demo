package com.example.test.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotNull(message = "Department Name Must Not Be Null!")
    private String departmentName;

    @NotNull(message = "Department Code Must Not Be Null!")
    private String departmentCode;

}
