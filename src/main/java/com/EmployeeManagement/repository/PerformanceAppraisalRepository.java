package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.Employee;
import com.EmployeeManagement.entity.PerformanceAppraisal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PerformanceAppraisalRepository extends JpaRepository<PerformanceAppraisal, Integer> {
    @Query("select e.employeeId, concat(e.firstName,' ',e.lastName) as fullname, p.rating " +
            "from PerformanceAppraisal p " +
            "inner join Employee e " +
            "on e.employeeId=p.employeeId " +
            "where (p.rating between ?1 and ?2 ) and p.appraisalDate between ?3 and ?4")
    List findByRatingBetween(Double initialRating, Double highestRating, LocalDate fistDateOfMonth, LocalDate lastDateOfMonth);
}
