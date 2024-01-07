package com.EmployeeManagement.repository;

import com.EmployeeManagement.entity.LeaveManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LeaveManagementRepository extends JpaRepository<LeaveManagement, Integer> {
    @Query("select  l from LeaveManagement l where l.leaveStatus = 'Pending'")
    List<LeaveManagement> getAllPendingLeaves();

    @Query("select count(l) from LeaveManagement  l where l.leaveStatus = 'Approved'")
    Integer getAllApprovedLeave(Integer employeeID);

    @Query("select  l from LeaveManagement  l where (l.leaveStartDate between ?1 and  ?2 ) and l.leaveStatus like 'app%'")
    List<LeaveManagement> findByLeaveStartDateBetween(LocalDate startDate, LocalDate endingDate);


    List<LeaveManagement> findByLeaveStartDate(LocalDate now);

//    @Query("select count(l) from LeaveManagement l where l.employeeId = ?1 and l.")
//    Integer findLeaveBalance(Integer employeeId, LocalDate firstDayOfMonth, LocalDate lastDayOfMonth);
}
