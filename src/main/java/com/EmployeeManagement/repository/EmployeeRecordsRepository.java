package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.EmployeeRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRecordsRepository extends JpaRepository<EmployeeRecords, Integer> {
}