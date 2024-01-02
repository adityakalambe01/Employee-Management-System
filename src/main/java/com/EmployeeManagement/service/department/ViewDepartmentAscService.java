package com.EmployeeManagement.service.department;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewDepartmentAscService {
    @Autowired
    DepartmentRepository departmentRepository;
    public List<Department> getDepartmentByAscOrder(){
        return departmentRepository.findOrderByDepartmentNameAsc();
    }
}
