package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.EmployeeCommunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCommunicationRepository extends JpaRepository<EmployeeCommunication, Integer> {
}