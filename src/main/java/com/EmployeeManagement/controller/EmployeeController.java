package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/Employee/")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("add")
    public boolean addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("{employeeId}/delete")
    public String deleteEmployee(@PathVariable Integer employeeId){
        if(
                employeeService.deleteEmployee(employeeId)
        ){
            return "Successfully deleted the employee having Employee Id: "+employeeId;
        }
        return "Invalid Employee Id: "+employeeId;
    }

    @GetMapping("{gender}/getAllByGender")
    public List<Employee> findByGender(@PathVariable String gender){
        return employeeService.findByGender(gender);
    }

    @GetMapping("getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("getAllDescBySalary")
    public List<Employee> getEmployeesBySalaryDescOrder(){
        return employeeService.getEmployeesBySalaryDescOrder();
    }

    @GetMapping("getAllAscBySalary")
    public List<Employee> getEmployeesBySalaryAscOrder(){
        return employeeService.getEmployeesBySalaryAscOrder();
    }

    @GetMapping("{startingDate}/JoinBetween/{endingDate}")
    public List<Employee> employeesJoinBetween(@PathVariable LocalDate startingDate,
                                               @PathVariable LocalDate endingDate){
        return employeeService.employeesJoinBetween(startingDate, endingDate);
    }

    @GetMapping("{starting}/SalaryBetween/{ending}")
    public List<Employee> getEmployeesBySalaryRanges(@PathVariable Double starting,
                                                     @PathVariable Double ending){
        return employeeService.getEmployeesBySalaryRanges(starting, ending);
    }

    @PutMapping("{employeeId}/update")
    public String updateEmployee(@PathVariable Integer employeeId,
                                 @RequestBody Employee updatedEmployee)
    {
        if(employeeService.updateEmployee(employeeId, updatedEmployee)){
            return "Successfully updated employee having Employee Id: "+employeeId;
        }
        return "Invalid Employee Id: "+employeeId;
    }

    @GetMapping("getById/{employeeId}")
    public Employee viewEmployeeById(@PathVariable Integer employeeId){
        return employeeService.viewEmployeeById(employeeId);
    }
}
