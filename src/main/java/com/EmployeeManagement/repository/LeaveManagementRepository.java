package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.LeaveManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagement, Integer> {
}
