package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    public List<Department> findByDepartmentNameLike(String departmentName);
}
