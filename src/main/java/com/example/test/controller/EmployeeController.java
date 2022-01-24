 package com.example.test.controller;

 import java.util.List;

import javax.validation.Valid;

import com.example.test.model.Employees;
import com.example.test.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService eService;
    
//    @Autowired
//    private EmployeeJPARepository employeeJpa;
    
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    private String getDetails() {
        return appName + " - " + appVersion;
    }

    // HTTP Method that can Read
    // @RequestMapping(value = "/employees", method = RequestMethod.GET)
    // Example for the Employees
    @GetMapping("/employees/details")
    public List<Employees> getEmployee(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        return eService.getEmployees(pageNumber, pageSize);
    }
    
    // HTTP Method that can Read
    @GetMapping("/employees/{id}")
    public Employees getEmployee2nd(@PathVariable Long id) {
        return eService.getEmployeeById(id);
    }

    @GetMapping("/employees/tostring")
    public String getEmployeeDetails() {
        Employees employees = new Employees();
        return employees.toString();
    }

    // HTTP Method that can Update the Employee Table
    @PutMapping("/employees/{id}")
    public Employees updateEmployees(@PathVariable Long id, @RequestBody Employees employees) {
        employees.setId(id);
        return eService.updateEmployeeDetails(id, employees);
    }

    // HTTP Method that can delete
    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam("id") Long Id) {
        eService.deleteEmployee(Id);
    }

    // HHTP Method that can create new Employee
    @PostMapping("/employee/add")
    public Employees createEmployee(@Valid @RequestBody Employees employees) {
    	return eService.createEmployee(employees);
    }
    
    // Using the JPA Query Methods
     
    @GetMapping("/employee/filterbyfullname")
    public Employees findByFirstName(@RequestParam String fullName) {
    	return eService.findByFullName(fullName);
    }
    
    @GetMapping("/employee/findtop10")
    public List<Employees> findTop10OrderByIdAsc() {
    	return eService.findTop10ByOrderByIdAsc();
    }
    
    @GetMapping("/employee/filterByFullNameAndDepartment")
    public List<Employees> getFullNameAndDepartment(@RequestParam String fullName, @RequestParam String department) {
		return eService.getFullNameAndAddress(fullName, department);
    }
    
    @GetMapping("/employee/filterByFullNameOrEmailAddress")
    public List<Employees> getFullNameOrEmailAddress(@RequestParam String fullName, @RequestParam String emailAddress) {
    	return eService.getFullNameOrEmailAddress(fullName, emailAddress);
    }
    
    @GetMapping("/employee/filterByKeyword")
    public List<Employees> getFullNameByKeyword(@RequestParam String keyword){
        return eService.getFullNameByKeyword(keyword);        
    }
}
