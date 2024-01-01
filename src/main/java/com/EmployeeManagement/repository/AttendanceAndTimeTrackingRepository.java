package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.AttendanceAndTimeTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceAndTimeTrackingRepository extends JpaRepository<AttendanceAndTimeTracking, Integer> {
}
