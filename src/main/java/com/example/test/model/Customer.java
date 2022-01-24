package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Setter
@Getter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Name must not be null or empty!")
    @Size(min = 7, max = 40)
    @NotEmpty(message = "Name must not be null or empty!")
    @Column(name = "full_name",
            nullable = false)
    private String fullName;

    @Min(value = 18)
    @NotNull(message = "Age must not be null or Empty!")
    @Column(name = "age",
            nullable = false)
    private int age;

    
    @NotNull(message = "Address must not be null or empty!")
    @NotEmpty(message = "Address must not be null or empty!")
    @Column(name = "address",
            nullable = false)
    private String address;

    @CreationTimestamp
    @Column(name = "created_at",
            nullable = false,
            updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
