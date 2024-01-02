package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.department.UpdateDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateDepartmentController {
    @Autowired
    UpdateDepartmentService updateDepartmentService;
    @RequestMapping(value = "updateDepartment/{departmentId}", method = RequestMethod.PUT)
    public boolean updateDepartment(@PathVariable Integer departmentId,@RequestBody Department department){
        return updateDepartmentService.updateDepartment(departmentId,department);
    }
}
