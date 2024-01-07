package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.Department;
import com.EmployeeManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Boolean addDepartment(Department department){
        departmentRepository.save(department);
        return true;
    }

    public boolean deleteDepartment(Integer departmentId){
        try{
            Department dbDepartment = departmentRepository.findById(departmentId).get();
            departmentRepository.delete(dbDepartment);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean updateDepartment(Integer id, Department department){
        try{
            Department dbDepartment = departmentRepository.findById(id).get();
            dbDepartment.setDepartmentName(department.getDepartmentName());
            dbDepartment.setDescription(department.getDescription());
            departmentRepository.save(dbDepartment);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<Department> viewAllDepartment(){
        return departmentRepository.findAll();
    }

    public List<Department> getDepartmentByAscOrder(){
        return departmentRepository.findOrderByDepartmentNameAsc();
    }

    public List<Department> findOrderByDepartmentNameDesc(){
        return departmentRepository.findOrderByDepartmentNameDesc();
    }

    public Department viewDepartmentById(Integer departmentId){
        try{
            return  departmentRepository.findById(departmentId).get();
        }catch (Exception e){
            return null;
        }
    }

    public List<Department> viewDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameLike(departmentName);
    }
}
