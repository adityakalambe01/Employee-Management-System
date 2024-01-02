package com.EmployeeManagement.service.employee;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public boolean updateEmployee(Integer employeeId, Employee updatedEmployee){
        try{
            Employee dbEmployee = employeeRepository.findById(employeeId).get();
            dbEmployee.setFirstName(updatedEmployee.getFirstName());
            dbEmployee.setLastName(updatedEmployee.getLastName());
            dbEmployee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            dbEmployee.setGender(updatedEmployee.getGender());
            dbEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
            dbEmployee.setEmailId(updatedEmployee.getEmailId());
            dbEmployee.setAddress(updatedEmployee.getAddress());
            dbEmployee.setJoiningDate(updatedEmployee.getJoiningDate());
            dbEmployee.setDepartmentId(updatedEmployee.getDepartmentId());
            dbEmployee.setPositionId(updatedEmployee.getPositionId());
            dbEmployee.setSalary(updatedEmployee.getSalary());

            employeeRepository.save(dbEmployee);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
