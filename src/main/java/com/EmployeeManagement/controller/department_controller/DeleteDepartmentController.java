package com.EmployeeManagement.controller.department_controller;

import com.EmployeeManagement.service.department.DeleteDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteDepartmentController {
    @Autowired
    DeleteDepartmentService deleteDepartmentService;
    @RequestMapping(value = "deleteDepartment/{departmentId}", method = RequestMethod.DELETE)
    public boolean deleteDepartment(@PathVariable Integer departmentId){
        return deleteDepartmentService.deleteDepartment(departmentId);
    }
}
