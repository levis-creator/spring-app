package com.micosoft.springapp.department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @Mock
    private DepartmentRepository departmentRepository;


    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT").departmentCode("IT-06").departmentAddress("Nairobi").departmentId(1L).build();
    }

    @Test
    @Disabled
    void createDepartment() {
    }

    @Test
    @Disabled
    void getAllDepartments() {
    }

    @Test
    @Disabled
    void getSingleDepartments() {
    }

    @Test
    @Disabled
    void deleteDepartment() {
    }

    @Test
    @Disabled
    void editDepartment() {
    }

    @Test
    void whenValidDepartmentName_thenDepartmentShouldFound() {
//        given
        String departmentName = "IT";
        Department department = new Department();
        Optional<Department> found = departmentService.gettingByName(departmentName);
//       then
        given(found).willReturn(Optional.of(department));
    }
}