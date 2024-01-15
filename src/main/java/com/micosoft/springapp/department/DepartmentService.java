package com.micosoft.springapp.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    Department createDepartment(Department department) {
        departmentRepository.save(department);
        return department;
    }

    List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getSingleDepartments(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            return department.get();
        } else {
            throw new DepartmentNotFoundException("Department not found");
        }
    }

    public void deleteDepartment(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            throw new DepartmentNotFoundException("Department Not found");
        }
    }

    public Department editDepartment(Long id, Department department) throws DepartmentNotFoundException {
        Optional <Department> optionalDepartment= departmentRepository.findById(id);

       if (optionalDepartment.isPresent()) {
           Department dbDepartment=optionalDepartment.get();
           if (!Objects.isNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()) && !Objects.equals(dbDepartment.getDepartmentName(), department.getDepartmentName())) {
               dbDepartment.setDepartmentName(department.getDepartmentName());
           }
           if (!Objects.isNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()) && !Objects.equals(dbDepartment.getDepartmentAddress(), department.getDepartmentAddress())) {
               dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
           }
           if (!Objects.isNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()) && !Objects.equals(dbDepartment.getDepartmentCode(), department.getDepartmentCode())) {
               dbDepartment.setDepartmentCode(department.getDepartmentCode());
           }
           return departmentRepository.save(dbDepartment);
       }else {
           throw new DepartmentNotFoundException("Department not found");
       }

    }

    public Optional<Department> gettingByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
