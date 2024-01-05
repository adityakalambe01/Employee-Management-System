package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.HumanResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourcesRepository extends JpaRepository<HumanResources, Integer> {
    @Query("select hr.hrId from HumanResources hr where hr.employeeId = ?1")
    Integer findByEmployeeId(Integer employeeId);

    @Query("select hr.hrTitle from HumanResources hr where hr.hrId = ?1")
    String findByHrTitle(Integer hrId);
}
