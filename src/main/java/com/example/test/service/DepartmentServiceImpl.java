package com.example.test.service;

import com.example.test.model.Department;
import com.example.test.repository.DepartmentJPARepository;

import java.util.List;
import java.util.Optional;

public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentJPARepository departmentJPARepository;

    DepartmentServiceImpl(DepartmentJPARepository departmentJPARepository) {
        this.departmentJPARepository = departmentJPARepository;
    }

    @Override
    public List<Department> getDepartments() {
        return departmentJPARepository.findAll();
    }

    @Override
    public Department addDepartment(Department department) {
        return departmentJPARepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentJPARepository.findById(id);
        if(department.isPresent()) {
            return department.get();
        }else {
            throw new RuntimeException("No Department!");
        }
    }
}
