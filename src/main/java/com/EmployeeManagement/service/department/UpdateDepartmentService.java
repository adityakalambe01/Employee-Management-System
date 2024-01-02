package com.EmployeeManagement.service.department;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    public Boolean updateDepartment(Integer id, Department department){
        try{
            Department dbDepartment = departmentRepository.findById(id).get();
            dbDepartment.setDepartmentName(department.getDepartmentName());
            dbDepartment.setDescription(department.getDescription());
            departmentRepository.save(dbDepartment);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
