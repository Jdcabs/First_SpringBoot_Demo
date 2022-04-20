package com.example.test.service;

import com.example.test.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();

    Department addDepartment(Department department);

    Department getDepartmentById(Long id);
}
