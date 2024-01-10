package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.SalaryAndCompensation;
import com.EmployeeManagement.service.SalaryAndCompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/SalaryAndCompensation/")
public class SalaryAndCompensationController {
    @Autowired
    SalaryAndCompensationService salaryAndCompensationService;

    @PostMapping("addSalaryAccount")
    public SalaryAndCompensation addSalaryAndCompensation(@RequestBody SalaryAndCompensation salaryAndCompensation){
        return salaryAndCompensationService.addSalaryAndCompensation(salaryAndCompensation);
    }

    @DeleteMapping("deleteSalary/Account/id/{salaryId}")
    public String deleteSalaryAndCompensation(@PathVariable Integer salaryId){
        return salaryAndCompensationService.deleteSalaryAndCompensation(salaryId)?
                "Successfully deleted "+salaryId : "Invalid salary id "+salaryId;
    }

    @GetMapping("getAllSalariedAccount")
    public List<SalaryAndCompensation> getAllSalaryAndCompensation(){
        return salaryAndCompensationService.getAllSalaryAndCompensation();
    }

    @GetMapping("getSalary/employee/id/{employeeId}")
    public String getSalaryByEmployeeId(@PathVariable Integer employeeId){
        Double employeeSalary = salaryAndCompensationService.getSalaryByEmployeeId(employeeId);
        return (employeeSalary==null) ?
                "Invalid employee id"+employeeId : "Salary of employee is "+employeeId+" is "+employeeSalary;

    }

    @GetMapping("getBonus/id/{employeeId}")
    public String getBonusesOfEmployee(@PathVariable Integer employeeId){
        Double bonus = salaryAndCompensationService.getBonusesOfEmployee(employeeId);
        return (bonus==null )?
                "Invalid employee id "+employeeId : "The bonus of employee id "+employeeId+" is "+bonus;
    }

    @GetMapping("average/salary/employees")
    public String averageSalaryOfAllEmployee(){
        double averageSalary = salaryAndCompensationService.avarageSalaryOfAllEmployee();
        return (averageSalary==0) ?
                "No such record found" : "Average salary of employees is "+averageSalary;
    }


    @GetMapping("total/salary/id/{employeeId}")
    public String totalSalaryOfEmployee(@PathVariable Integer employeeId){
        Double totalSalary = salaryAndCompensationService.totalSalaryOfEmployee(employeeId);
        return (totalSalary==null)?
                "Invalid employee id "+employeeId : "The total salary of employee "+employeeId+" is "+totalSalary;
    }

    @GetMapping("calculate/salary/allemployee")
    public String totalSalaryOfAllEmployees(){
        double totalSalary = salaryAndCompensationService.totalSalaryOfAllEmployees();
        return (totalSalary==0) ?
                "Sorry no records found" : "The total salary of all employee is "+totalSalary;
    }

    @PostMapping("increase/salary/employeelist/{employeeList}/{amount}")
    public List<SalaryAndCompensation> increaseSalaryOfEmployees(@PathVariable List<Integer> employeeList,
                                                                 @PathVariable Double amount){
        return salaryAndCompensationService.increaseSalaryOfEmployees(employeeList, amount);
    }

    @GetMapping("count/all")
    public String countAll(){
        Integer count = salaryAndCompensationService.countAll();
        String countString = "The total count is ";
        return (count == 0) ?
                 "No record found." : countString+count+".";
    }

    @GetMapping("highest/five/salary/employee")
    public List<SalaryAndCompensation> highestFiveSalariesEmployees(){
        return salaryAndCompensationService.highestFiveSalariesEmployees();
    }

    @GetMapping("lowest/five/salary/employee")
    public List<SalaryAndCompensation> lowestFiveSalariesEmployees(){
        return salaryAndCompensationService.lowestFiveSalariesEmployees();
    }

    @GetMapping("basesalary/id/{employeeId}")
    public String getBaseSalaryOfEmployee(@PathVariable Integer employeeId){
        Double baseSalary = salaryAndCompensationService.getBaseSalaryOfEmployee(employeeId);
        return (baseSalary==null) ?
                "No record found of employee id "+employeeId : "The base Salary of employee id "+employeeId+" is "+baseSalary;
    }

}
