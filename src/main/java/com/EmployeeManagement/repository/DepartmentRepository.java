package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByDepartmentNameLike(String departmentName);

    @Query("select d from Department d order by d.departmentName")
    List<Department> findOrderByDepartmentNameAsc();

    @Query("select d from Department d order by d.departmentName desc ")
    List<Department> findOrderByDepartmentNameDesc();

}
