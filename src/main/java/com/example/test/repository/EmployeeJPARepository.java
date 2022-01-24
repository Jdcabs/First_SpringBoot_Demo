package com.example.test.repository;

import java.util.List;

import com.example.test.model.Employees;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends PagingAndSortingRepository<Employees, Long> {
	
	Employees findByFullName(String firstName);
	
	List<Employees> findTop10ByOrderByIdAsc();
	
	//List<Employees> findByFullNameOrderByFullName();
	
	List<Employees> findByFullNameAndEmployeeDepartment(String fullName, String employeeDepartment);
	
	List<Employees> findByFullNameOrEmailAddress(String fullName, String emailAddress);

	List<Employees> findByFullNameContaining(String keyword, Sort sort);
}
