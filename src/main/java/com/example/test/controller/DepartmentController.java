package com.example.test.controller;

import com.example.test.model.Department;
import com.example.test.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("api/v1")
public class DepartmentController {

    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    @RequestMapping("/departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/departments")
    public Department addDepartment(@Valid @RequestBody Department department){
        return departmentService.addDepartment(department);
    }
}
