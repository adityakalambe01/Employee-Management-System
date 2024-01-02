package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindByGenderService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> findByGender(String gender){
        return employeeRepository.findByGender(gender);
    }
}
