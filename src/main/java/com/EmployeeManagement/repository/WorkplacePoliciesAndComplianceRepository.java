package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.WorkplacePoliciesAndCompliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplacePoliciesAndComplianceRepository extends JpaRepository<WorkplacePoliciesAndCompliance, Integer> {
}
