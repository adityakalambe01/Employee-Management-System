package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.AttendanceAndTimeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceAndTimeTrackingRepository extends JpaRepository<AttendanceAndTimeTracking, Integer> {
    @Query("select a.employeeId from AttendanceAndTimeTracking a where a.datePresent = ?1")
    List<Integer> findByDatePresent(LocalDate now);
}
