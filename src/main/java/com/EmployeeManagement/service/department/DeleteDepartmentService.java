package com.EmployeeManagement.service.department;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public boolean deleteDepartment(Integer departmentId){
        try{
            Department dbDepartment = departmentRepository.findById(departmentId).get();
            departmentRepository.delete(dbDepartment);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
