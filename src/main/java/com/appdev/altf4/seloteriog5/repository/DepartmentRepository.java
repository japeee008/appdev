package com.appdev.altf4.seloteriog5.repository;

import com.appdev.altf4.seloteriog5.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
