package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewEmployeeByIdService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee viewEmployeeById(Integer employeeId){
        try{
            return employeeRepository.findById(employeeId).get();
        }catch (Exception e){
            return null;
        }
    }
}
