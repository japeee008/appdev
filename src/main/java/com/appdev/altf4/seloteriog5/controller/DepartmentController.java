package com.appdev.altf4.seloteriog5.controller;

import com.appdev.altf4.seloteriog5.entity.Department;
import com.appdev.altf4.seloteriog5.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "http://localhost:5173") // adjust port for your React app
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // CREATE
    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    // READ ALL
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
