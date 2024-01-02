package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.department.ViewAllDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewAllDepartmentController {
    @Autowired
    ViewAllDepartmentService viewAllDepartmentService;
    @RequestMapping(value = "allDepartments", method = RequestMethod.GET)
    public List<Department> viewAllDepartment(){
        return viewAllDepartmentService.viewAllDepartment();
    }
}
