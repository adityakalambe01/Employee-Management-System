package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.department.ViewDepartmentByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ViewDepartmentByNameController {
    @Autowired
    ViewDepartmentByNameService viewDepartmentByNameService;
    @RequestMapping(value = "viewDepartmentByName/{departmentName}", method = RequestMethod.GET)
    public List<Department> viewDepartmentByName(@PathVariable String departmentName){
        return viewDepartmentByNameService.viewDepartmentByName(departmentName);
    }
}
