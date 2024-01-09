package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.SalaryAndCompensation;
import com.EmployeeManagement.repository.SalaryAndCompensationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SalaryAndCompensationService {
    @Autowired
    SalaryAndCompensationRepository salaryAndCompensationRepository;

    public SalaryAndCompensation addSalaryAndCompensation(SalaryAndCompensation salaryAndCompensation){

        return salaryAndCompensationRepository.save(salaryAndCompensation);
    }

    public boolean deleteSalaryAndCompensation(Integer salaryId){
        try{
            salaryAndCompensationRepository.deleteById(salaryId);
        }catch (Exception e){
            return false;
        }
        return true;
    }


    public List<SalaryAndCompensation> getAllSalaryAndCompensation(){
        return salaryAndCompensationRepository.findAll();
    }
    public Double getSalaryByEmployeeId(Integer employeeId){
        SalaryAndCompensation s1;
        try{
            s1 = salaryAndCompensationRepository.findByEmployeeId(employeeId);
        }catch (Exception e){
            return null;
        }
        return s1.getBaseSalary();
    }

    public Double getBaseSalaryOfEmployee(Integer employeeId){
        SalaryAndCompensation s1;
        try{
            s1 = salaryAndCompensationRepository.findByEmployeeId(employeeId);
        }catch (Exception e){
            return null;
        }
        return s1.getBaseSalary();
    }

    public Double getBonusesOfEmployee(Integer employeeId){
        SalaryAndCompensation s1;
        try{
            s1 = salaryAndCompensationRepository.findByEmployeeId(employeeId);
        }catch (Exception e){
            return null;
        }
        return s1.getBonuses();
    }

    public Double avarageSalaryOfAllEmployee(){
        List<SalaryAndCompensation> lst = salaryAndCompensationRepository.findAll();
        double avarage = 0;
        for (SalaryAndCompensation obj : lst){
            avarage+= obj.getBaseSalary();
        }
        try{
            return avarage/lst.size();
        }catch (Exception e){
            return (double)0;
        }
    }

    public Double totalSalaryOfEmployee(Integer employeeId){
        try{
            SalaryAndCompensation obj = salaryAndCompensationRepository.findByEmployeeId(employeeId);
            return obj.getBaseSalary() + obj.getBonuses();
        }catch (Exception e){
            return null;
        }
    }
    public Double totalSalaryOfAllEmployees(){
        List<SalaryAndCompensation> list = salaryAndCompensationRepository.findAll();
        double total = 0;
        for (SalaryAndCompensation employee : list){
            total+=employee.getBaseSalary();
        }
        return total;
    }

    public List<SalaryAndCompensation> increaseSalaryOfEmployees(List<Integer> employeeList, Double amount){
        List<SalaryAndCompensation> lst = salaryAndCompensationRepository.findAllById(employeeList);
        for(Integer employeeId : employeeList){
            for (SalaryAndCompensation employee : lst){
                if(
                        Objects.equals(employeeId, employee.getEmployeeId())
                ){
                    employee.setBaseSalary(employee.getBaseSalary()+amount);
                    salaryAndCompensationRepository.save(employee);
                    break;
                }
            }
        }
        return salaryAndCompensationRepository.findAll();
    }

    public Integer countAll(){
        return salaryAndCompensationRepository.findAll().size();
    }

    public List<SalaryAndCompensation> highestFiveSalariesEmployees(){
        return salaryAndCompensationRepository.highestFiveSalariesEmployees()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<SalaryAndCompensation> lowestFiveSalariesEmployees(){
        return salaryAndCompensationRepository.lowestFiveSalariesEmployees()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }


}
