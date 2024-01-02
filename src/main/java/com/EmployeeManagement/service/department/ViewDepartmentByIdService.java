package com.EmployeeManagement.service.department;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewDepartmentByIdService {
    @Autowired
    DepartmentRepository departmentRepository;
    public Department viewDepartmentById(Integer departmentId){
        try{
            return  departmentRepository.findById(departmentId).get();
        }catch (Exception e){
            return null;
        }
    }
}
