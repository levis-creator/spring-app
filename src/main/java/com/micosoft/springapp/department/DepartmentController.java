package com.micosoft.springapp.department;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
@AllArgsConstructor
public class DepartmentController {


    @Autowired
    private final DepartmentService departmentService;

    @GetMapping
    List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("{id}")
    Department getDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.getSingleDepartments(id);
    }

    @PostMapping
    Department addingDepartment(@Valid @RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("{id}")
    Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) throws DepartmentNotFoundException {
        return departmentService.editDepartment(id, department);
    }

    @DeleteMapping("{id}")
    String deletingDepartment(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        departmentService.deleteDepartment(id);
        return "Department deleted successfully";
    }

    @GetMapping(params = "name")
    Optional<Department> getDepartmentByName(@RequestParam(required = false) String name) {
        return departmentService.gettingByName(name);
    }
}
