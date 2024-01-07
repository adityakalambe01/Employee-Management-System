package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.LeaveManagement;
import com.EmployeeManagement.repository.LeaveManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class LeaveManagementService {
    @Autowired
    LeaveManagementRepository leaveManagementRepository;
    public Integer addLeaveRecord(LeaveManagement leaveManagement){
        return leaveManagementRepository.save(leaveManagement).getLeaveId();
    }

    public Boolean deleteLeaveRecord(Integer leaveId){
        try {
            leaveManagementRepository.delete(
                    leaveManagementRepository.findById(leaveId).get()
            );
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean updateLeaveRecord(Integer leaveId, LeaveManagement leaveManagement){
        try {
            LeaveManagement dbLeaveManagement = leaveManagementRepository.findById(leaveId).get();
            dbLeaveManagement.setEmployeeId(
                    leaveManagement.getEmployeeId()
            );
            dbLeaveManagement.setLeaveType(
                    leaveManagement.getLeaveType()
            );
            dbLeaveManagement.setLeaveStatus(
                    leaveManagement.getLeaveStatus()
            );
            dbLeaveManagement.setLeaveStartDate(
                    leaveManagement.getLeaveStartDate()
            );
            dbLeaveManagement.setLeaveEndDate(
                    leaveManagement.getLeaveEndDate()
            );

            leaveManagementRepository.save(dbLeaveManagement);

        }catch (Exception e){
            return false;
        }
        return true;
    }

    public String updateLeaveStatus(Integer leaveId, String leaveStatus){
        try{
            LeaveManagement leaveManagement = leaveManagementRepository.findById(leaveId).get();
            leaveManagement.setLeaveStatus(leaveStatus);
            leaveManagementRepository.save(leaveManagement);
        }catch (Exception e){
            return "Invalid leave id "+leaveId;
        }
        return "leave status changed to "+leaveStatus;
    }

    public List<LeaveManagement> getAllPendingLeaves(){
        return leaveManagementRepository.getAllPendingLeaves();
    }

    public Integer getTotalLeave(Integer employeeID){
        return leaveManagementRepository.getAllApprovedLeave(employeeID);
    }

    public LeaveManagement getLeaveInfoOfEmployee(Integer leaveId){
        try{
            return leaveManagementRepository.findById(leaveId).get();
        }catch (Exception e){
            return null;
        }
    }

    public List<LeaveManagement> getLeavesBetweenDays(LocalDate startDate, LocalDate endingDate){
        return leaveManagementRepository.findByLeaveStartDateBetween(startDate, endingDate);
    }

    public List<LeaveManagement> getLeaveBetweenCurrentMonth(){
        LocalDate todayDate = LocalDate.now();
        LocalDate firstDate = todayDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate lastDate = todayDate.with(TemporalAdjusters.lastDayOfMonth());
        return leaveManagementRepository.findByLeaveStartDateBetween(firstDate, lastDate);
    }

    //rebuild
    public List<LeaveManagement> getCurrentDateLeave(){
        return leaveManagementRepository.findByLeaveStartDate(LocalDate.now());
    }

//    public Integer leaveBalance(Integer employeeId){
//        LocalDate today = LocalDate.now();
//        LocalDate firstDayOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
//        LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
//        return leaveManagementRepository.findLeaveBalance(employeeId, firstDayOfMonth, lastDayOfMonth);
//    }



}
