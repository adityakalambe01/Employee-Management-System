package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.HumanResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanResourcesRepository extends JpaRepository<HumanResources, Integer> {
}
