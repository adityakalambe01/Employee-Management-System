package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.department.AddDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddDepartmentController {
    @Autowired
    AddDepartmentService addDepartmentService;
    @RequestMapping(value = "addDepartment", method = RequestMethod.POST)
    public boolean addDepartment(@RequestBody Department department){
        System.out.println(department);
        return addDepartmentService.addDepartment(department);
    }
}
