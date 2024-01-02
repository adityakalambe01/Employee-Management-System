package com.EmployeeManagement.service.department;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public Boolean addDepartment(Department department){
        departmentRepository.save(department);
        return true;
    }
}
