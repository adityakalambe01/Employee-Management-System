package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.AttendanceAndTimeTracking;
import com.EmployeeManagement.repository.AttendanceAndTimeTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceAndTimeTrackingService {
    @Autowired
    AttendanceAndTimeTrackingRepository attendanceAndTimeTrackingRepository;

    public Integer addAttendance(Integer employeeId){
        AttendanceAndTimeTracking ant = new AttendanceAndTimeTracking();
        ant.setEmployeeId(employeeId);
        ant.setDatePresent(LocalDate.now());
        ant.setClockInTime(LocalTime.now());
        attendanceAndTimeTrackingRepository.save(ant);
        return ant.getAttendanceId();
    }

    public LocalTime updateClockOutTime(Integer attendanceId){
        AttendanceAndTimeTracking ant;
        try {
            ant = attendanceAndTimeTrackingRepository.findById(attendanceId).get();
            ant.setClockOutTime(LocalTime.now());
            attendanceAndTimeTrackingRepository.save(ant);
        }catch (Exception e){
            return null;
        }
        return ant.getClockOutTime();
    }

    public List<AttendanceAndTimeTracking> fullDaysInMonth(){
        return null;
    }

    public List<AttendanceAndTimeTracking> halfDaysInMonth(){
        return null;
    }

    public List<AttendanceAndTimeTracking> getAllAttendance(){
        return attendanceAndTimeTrackingRepository.findAll();
    }

    public List<Integer> currentDateAttendanceOfEmployee(){
        return attendanceAndTimeTrackingRepository.findByDatePresent(LocalDate.now());
    }
}
