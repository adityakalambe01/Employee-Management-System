package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public boolean deleteEmployee(Integer employeeId){
        try {
            Employee dbEmployee = employeeRepository.findById(employeeId).get();
            employeeRepository.delete(dbEmployee);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
