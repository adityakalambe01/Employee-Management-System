package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByFirstNameLikeAndLastNameLike(String firstName, String LastName);
    List<Employee> findBySalaryBetween(Double salary, Double salary2);

    List<Employee> findByJoiningDateBetween(LocalDate startYear, LocalDate endYear);

//    @Query("select e from Employee e where e.gender=:gender")
    List<Employee> findByGender(@Param("gender") String gender);

    @Query("select e from Employee e order by e.salary")
    List<Employee> findByOrderSalaryAsc();

    @Query("select e from Employee e order by e.salary desc")
    List<Employee> findByOrderSalaryDesc();


}
