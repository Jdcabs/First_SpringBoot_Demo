package com.example.test.service;

import com.example.test.model.Employees;
import com.example.test.repository.EmployeeJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private EmployeeJPARepository employeeJPARepository;


	// Return All the Employee Details
    @Override
    public List<Employees> getEmployees(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Direction.ASC, "id");
		return employeeJPARepository.findAll(pageable).getContent();
    }

	// Create New Employee
	@Override
	public Employees createEmployee(Employees employees) {
		return employeeJPARepository.save(employees);
	}

	// Return Employee Details by ID.
	@Override
	public Employees getEmployeeById(Long id) {
		Optional<Employees> employees =  employeeJPARepository.findById(id);
		
		if(employees.isPresent()) {
			return employees.get();
		}else {
			throw new RuntimeException("ERROR! No Employee Found ( id: " + id + " )");
		}
	}
	
	// This will Delete the Data of the Employee with the given Id.
	@Override
	public void deleteEmployee(Long id) {
		Optional<Employees> employees = employeeJPARepository.findById(id);

		if(employees.isPresent()){
			employeeJPARepository.deleteById(id);
		}
		throw new RuntimeException("Employee doesn't Exist! Cannot Delete thi with ID: " + id);
	}
	
	// This will Update the detail of the Employee with the given Id and the Properties.
	@Override
	public Employees updateEmployeeDetails(Long id, Employees employees) {
		Optional<Employees> checkForTheID = employeeJPARepository.findById(id);

		if(checkForTheID.isPresent() == true){
			return employeeJPARepository.save(employees);
		}else {
			throw new RuntimeException("ERROR! The Employee Doesn't Exist ( id: " + id + " )");
		}
	}

	@Override
	public Employees findByFullName(String firstName) {
		return employeeJPARepository.findByFullName(firstName);
	}

	@Override
	public List<Employees> findTop10ByOrderByIdAsc() {
		return employeeJPARepository.findTop10ByOrderByIdAsc();
	}

	@Override
	public List<Employees> getFullNameAndAddress(String fullName, String employeeDepartment) {
		return employeeJPARepository.findByFullNameAndEmployeeDepartment(fullName, employeeDepartment);
	}

	@Override
	public List<Employees> getFullNameOrEmailAddress(String fullName, String emailAddress) {
		return employeeJPARepository.findByFullNameOrEmailAddress(fullName, emailAddress);
	}

	@Override
	public List<Employees> getFullNameByKeyword(String keyword) {
		Sort sort = Sort.by(Direction.DESC, "id");
		return employeeJPARepository.findByFullNameContaining(keyword, sort);
	}
}
