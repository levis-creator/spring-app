package com.micosoft.springapp.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentName(String departmentName);
    Optional<Department> findByDepartmentNameIgnoreCase(String departmentName);
}
