package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

    @Query("select p from Position p where p.positionName like %?1%")
    List<Position> findByPositionNameLike(String positionName);

    List<Position> findBySalaryRangeBetween(Double minimumSalary, Double highestSalary);

    @Query("select p from Position  p order by p.salaryRange")
    List<Position> findByPositionSalaryAsc();

    @Query("select p from Position  p order by p.salaryRange desc")
    List<Position> findByPositionSalaryDesc();
}
