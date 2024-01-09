package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.LeaveManagement;
import com.EmployeeManagement.service.LeaveManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/LeaveManagement/")
public class LeaveManagementController {
    @Autowired
    LeaveManagementService leaveManagementService;
    @PostMapping("addLeave")
    public String addLeaveRecord(LeaveManagement leaveManagement){
        Integer leaveId = leaveManagementService.addLeaveRecord(leaveManagement);
        return "Your leave id is "+leaveId;
    }

    @DeleteMapping("{leaveId}/delete")
    public String deleteLeaveRecord(@PathVariable Integer leaveId){
        return leaveManagementService.deleteLeaveRecord(leaveId) ?
                "Successfully delete leave record of id "+leaveId : "Invalid leave id "+leaveId;
    }

    @PutMapping("{leaveId}/update")
    public String updateLeaveRecord(@PathVariable Integer leaveId,
                                    @RequestBody LeaveManagement leaveManagement){
        return leaveManagementService.updateLeaveRecord(leaveId, leaveManagement) ?
                "Successfully updated record of leave id "+leaveId : "Invalid leave id "+leaveId;
    }

    @PutMapping("id/{leaveId}/updateStatus/{leaveStatus}")
    public String updateLeaveStatus(@PathVariable Integer leaveId,
                                    @PathVariable String leaveStatus){
        return leaveManagementService.updateLeaveStatus(leaveId, leaveStatus);
    }

    @GetMapping("allPendingLeaves")
    public List<LeaveManagement> getAllPendingLeaves(){
        return leaveManagementService.getAllPendingLeaves();
    }

    @GetMapping("allApprovedLeaves")
    public Integer getTotalLeaves(Integer employeeId){
        return leaveManagementService.getTotalLeave(employeeId);
    }

    @GetMapping("leaveInfo/id/{leaveId}")
    public LeaveManagement getLeaveInfoOfEmployee(@PathVariable Integer leaveId){
        return leaveManagementService.getLeaveInfoOfEmployee(leaveId);
    }

    @GetMapping("leavesBetween/{startDate}/to/{endingDate}")
    public List<LeaveManagement> getLeavesBetweenDays(@PathVariable LocalDate startDate,
                                                      @PathVariable LocalDate endingDate){
        return leaveManagementService.getLeavesBetweenDays(startDate, endingDate);
    }

    @GetMapping("current/month/leaves")
    public List<LeaveManagement> getLeaveBetweenCurrentMonth(){
        return leaveManagementService.getLeaveBetweenCurrentMonth();
    }

    @GetMapping("todays/leaves")
    public List<LeaveManagement> getCurrentDateLeave(){
        return leaveManagementService.getCurrentDateLeave();
    }
}
