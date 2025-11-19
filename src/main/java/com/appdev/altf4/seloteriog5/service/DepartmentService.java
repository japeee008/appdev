package com.appdev.altf4.seloteriog5.service;

import com.appdev.altf4.seloteriog5.entity.Department;
import com.appdev.altf4.seloteriog5.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // CREATE
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // READ ALL
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // READ ONE
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found with id " + id));
    }

    // UPDATE
    public Department updateDepartment(Long id, Department updated) {
        Department existing = getDepartmentById(id);

        if (updated.getDeptName() != null) {
            existing.setDeptName(updated.getDeptName());
        }
        if (updated.getEmail() != null) {
            existing.setEmail(updated.getEmail());
        }

        return departmentRepository.save(existing);
    }

    // DELETE
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new RuntimeException("Department not found with id " + id);
        }
        departmentRepository.deleteById(id);
    }
}
