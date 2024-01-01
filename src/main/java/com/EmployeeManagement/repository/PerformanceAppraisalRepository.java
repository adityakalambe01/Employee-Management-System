package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.PerformanceAppraisal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceAppraisalRepository extends JpaRepository<PerformanceAppraisal, Integer> {
}
