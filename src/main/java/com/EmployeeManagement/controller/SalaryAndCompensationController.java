package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.SalaryAndCompensation;
import com.EmployeeManagement.service.SalaryAndCompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/SalaryAndCompensation/")
public class SalaryAndCompensationController {
    @Autowired
    SalaryAndCompensationService salaryAndCompensationService;

    public SalaryAndCompensation addSalaryAndCompensation(SalaryAndCompensation salaryAndCompensation){
        return salaryAndCompensationService.addSalaryAndCompensation(salaryAndCompensation);
    }

    public String deleteSalaryAndCompensation(Integer salaryId){
        return salaryAndCompensationService.deleteSalaryAndCompensation(salaryId)?
                "Successfully deleted "+salaryId : "Invalid salary id "+salaryId;
    }

    public List<SalaryAndCompensation> getAllSalaryAndCompensation(){
        return salaryAndCompensationService.getAllSalaryAndCompensation();
    }

    public String getSalaryByEmployeeId(Integer employeeId){
        Double employeeSalary = salaryAndCompensationService.getSalaryByEmployeeId(employeeId);
        return (employeeSalary==null) ?
                "Invalid employee id"+employeeId : "Salary of employee is "+employeeId+" is "+employeeSalary;

    }

    public String getBonusesOfEmployee(Integer employeeId){
        Double bonus = salaryAndCompensationService.getBonusesOfEmployee(employeeId);
        return (bonus==null )?
                "Invalid employee id "+employeeId : "The bonus of employee id "+employeeId+" is "+bonus;
    }

    public String avarageSalaryOfAllEmployee(){
        double avarageSalary = salaryAndCompensationService.avarageSalaryOfAllEmployee();
        return (avarageSalary==0) ?
                "No such record found" : "Avarage salary of employees is "+avarageSalary;
    }

    public String totalSalaryOfEmployee(Integer employeeId){
        return "";
    }
}
