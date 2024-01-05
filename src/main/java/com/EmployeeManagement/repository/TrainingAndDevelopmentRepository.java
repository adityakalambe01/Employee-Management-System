package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.TrainingAndDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingAndDevelopmentRepository extends JpaRepository<TrainingAndDevelopment, Integer> {
    @Query("select t from TrainingAndDevelopment t where t.employeeId= ?1")
    List<TrainingAndDevelopment> findAllByEmployeeId(Integer employeeID);
}
