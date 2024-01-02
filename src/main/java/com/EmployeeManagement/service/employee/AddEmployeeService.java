package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Boolean addEmployee(Employee employee){
        employeeRepository.save(employee);
        return true;
    }
}
