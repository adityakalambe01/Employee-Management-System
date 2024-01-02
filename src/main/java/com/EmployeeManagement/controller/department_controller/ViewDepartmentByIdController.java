package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.department.ViewDepartmentByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewDepartmentByIdController {
    @Autowired
    ViewDepartmentByIdService viewDepartmentByIdService;
    @RequestMapping(value = "viewDepartmentById/{departmentId}", method = RequestMethod.GET)
    public Department viewDepartmentById(@PathVariable Integer departmentId){
        return viewDepartmentByIdService.viewDepartmentById(departmentId);
    }
}
