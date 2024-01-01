package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.TrainingAndDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingAndDevelopmentRepository extends JpaRepository<TrainingAndDevelopment, Integer> {
}
