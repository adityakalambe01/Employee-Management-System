package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public Boolean addEmployee(Employee employee){
        employeeRepository.save(employee);
        return true;
    }

    public boolean deleteEmployee(Integer employeeId){
        try {
            Employee dbEmployee = employeeRepository.findById(employeeId).get();
            employeeRepository.delete(dbEmployee);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Employee> findByGender(String gender){
        return employeeRepository.findByGender(gender);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeesBySalaryDescOrder(){
        return employeeRepository.findByOrderSalaryDesc();
    }

    public List<Employee> employeesJoinBetween(LocalDate startingDate, LocalDate endingDate){
        return employeeRepository.findByJoiningDateBetween(startingDate, endingDate);
    }

    public List<Employee> getEmployeesBySalaryAscOrder(){
        return employeeRepository.findByOrderSalaryAsc();
    }

    public List<Employee> getEmployeesBySalaryRanges(Double starting, Double ending){
        return employeeRepository.findBySalaryBetween(starting, ending);
    }

    public boolean updateEmployee(Integer employeeId, Employee updatedEmployee){
        try{
            Employee dbEmployee = employeeRepository.findById(employeeId).get();
            dbEmployee.setFirstName(
                    updatedEmployee.getFirstName()
            );
            dbEmployee.setLastName(
                    updatedEmployee.getLastName()
            );
            dbEmployee.setDateOfBirth(
                    updatedEmployee.getDateOfBirth()
            );
            dbEmployee.setGender(
                    updatedEmployee.getGender()
            );
            dbEmployee.setMobileNumber(
                    updatedEmployee.getMobileNumber()
            );
            dbEmployee.setEmailId(
                    updatedEmployee.getEmailId()
            );
            dbEmployee.setAddress(
                    updatedEmployee.getAddress()
            );
            dbEmployee.setJoiningDate(
                    updatedEmployee.getJoiningDate()
            );
            dbEmployee.setDepartmentId(
                    updatedEmployee.getDepartmentId()
            );
            dbEmployee.setPositionId(
                    updatedEmployee.getPositionId()
            );
            dbEmployee.setSalary(
                    updatedEmployee.getSalary()
            );

            employeeRepository.save(dbEmployee);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Employee viewEmployeeById(Integer employeeId){
        try{
            return employeeRepository.findById(employeeId).get();
        }catch (Exception e){
            return null;
        }
    }
}
