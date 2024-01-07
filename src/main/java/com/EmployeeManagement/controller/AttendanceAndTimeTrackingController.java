package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.AttendanceAndTimeTracking;
import com.EmployeeManagement.service.AttendanceAndTimeTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("api/AttendanceAndTimeTracking/")
public class AttendanceAndTimeTrackingController {

    @Autowired
    AttendanceAndTimeTrackingService service;
    @PostMapping("{employeeId}/addAttendance")
    public Integer addAttendance(@PathVariable Integer employeeId){
        return service.addAttendance(employeeId);
    }

    @GetMapping("getAllAttendance")
    public List<AttendanceAndTimeTracking> getAllAttendance(){
        return service.getAllAttendance();
    }

    @GetMapping("getCurrentDateAttandance")
    public List<Integer> currentDateAttendanceOfEmployees(){
        return service.currentDateAttendanceOfEmployee();
    }

    @PutMapping("updateClockOutTime")
    public LocalTime updateClockOutTime(Integer attendanceId){
        return service.updateClockOutTime(attendanceId);
    }

    @GetMapping("fullDaysInMonth")
    public List<AttendanceAndTimeTracking> fullDaysInMonth(){
        return service.fullDaysInMonth();
    }

    @GetMapping("halfDaysInMonth")
    public List<AttendanceAndTimeTracking> halfDaysInMonth(){
        return service.halfDaysInMonth();
    }
}
