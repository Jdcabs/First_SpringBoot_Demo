package com.example.test.service;

import java.util.List;

import com.example.test.model.Employees;

public interface EmployeeService {
    // Return All the Employees Detail
    List<Employees> getEmployees(Integer pageNumber, Integer pageSize);

    // Create New Employee
    Employees createEmployee(Employees employees);

    // Return Employee Details by ID.
    Employees getEmployeeById(Long id);

    // This will Delete the Data inside the table with the provided ID.
    void deleteEmployee(Long id);

    // This Will Update the Data of the Employee Inside the Table provided.
    Employees updateEmployeeDetails(Long id, Employees employees);
    
    Employees findByFullName(String firstName);
    
    List<Employees> findTop10ByOrderByIdAsc();
    
    List<Employees> getFullNameAndAddress(String fullName, String employeeDepartment);
    
    List<Employees> getFullNameOrEmailAddress(String fullName, String emailAddress);

    List<Employees> getFullNameByKeyword(String keyword);
}
