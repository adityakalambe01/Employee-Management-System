package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.SalaryAndCompensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryAndCompensationRepository extends JpaRepository<SalaryAndCompensation, Integer> {
    SalaryAndCompensation findByEmployeeId(Integer employeeId);


    @Query("select s from SalaryAndCompensation s order by s.baseSalary desc")
    List<SalaryAndCompensation> highestFiveSalariesEmployees();

    @Query("select s from SalaryAndCompensation s order by s.baseSalary")
    List<SalaryAndCompensation> lowestFiveSalariesEmployees();
}
