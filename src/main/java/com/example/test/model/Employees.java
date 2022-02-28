package com.example.test.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tbl_employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull(message = "FullName must not be null or empty")
	@Column(name = "full_name")
    private String fullName;

	@NotNull(message = "FullAddress must not be null or empty")
	@Column(name = "full_address")
    private String fullAddress;

	@Email(message = "Please Enter a Valid Email Address.")
	@Column(name = "email_address",
			nullable = false)
    private String emailAddress;

	@NotNull(message = "department must not be null or empty")
	@Column(name = "department")
    private String employeeDepartment;

	@CreationTimestamp
	@Column(name = "created_at",
			nullable = false,
			updatable = false)
	private Date createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
}
