package com.example.test.repository;

import com.example.test.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentJPARepository extends JpaRepository<Department, Long> {}
