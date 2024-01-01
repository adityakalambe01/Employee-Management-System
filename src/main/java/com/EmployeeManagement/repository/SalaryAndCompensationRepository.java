package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.SalaryAndCompensation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryAndCompensationRepository extends JpaRepository<SalaryAndCompensation, Integer> {
}
