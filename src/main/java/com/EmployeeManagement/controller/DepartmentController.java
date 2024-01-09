package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Department/")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("addDepartment")
    public boolean addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("deleteDepartment")
    public boolean deleteDepartment(Integer departmentId){
        return departmentService.deleteDepartment(departmentId);
    }

    @PutMapping("{departmentId}/updateDepartment")
    public boolean updateDepartment(@PathVariable Integer departmentId, @RequestBody Department updatedDepartment){
        return departmentService.updateDepartment(departmentId, updatedDepartment);
    }

    @GetMapping("viewAllDepartment")
    public List<Department> viewAllDepartment(){
        return departmentService.viewAllDepartment();
    }

    @GetMapping("getDepartmentByAscOrder")
    public List<Department> getDepartmentByAscOrder(){
        return departmentService.getDepartmentByAscOrder();
    }

    @GetMapping("getDepartmentByDescOrder")
    public List<Department> findOrderByDepartmentNameDesc(){
        return departmentService.findOrderByDepartmentNameDesc();
    }

    @GetMapping("{departmentId}/viewDepartmentById")
    public Department viewDepartmentById(@PathVariable Integer departmentId){
        return departmentService.viewDepartmentById(departmentId);
    }

    @GetMapping("{departmentName}/viewDepartmentByName")
    public List<Department> viewDepartmentByName(@PathVariable String departmentName){
        return departmentService.viewDepartmentByName(departmentName);
    }
}
