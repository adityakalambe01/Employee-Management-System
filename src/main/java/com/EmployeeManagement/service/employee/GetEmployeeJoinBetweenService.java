package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GetEmployeeJoinBetweenService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> employeesJoinBetween(LocalDate startingDate, LocalDate endingDate){
        return employeeRepository.findByJoiningDateBetween(startingDate, endingDate);
    }
}
