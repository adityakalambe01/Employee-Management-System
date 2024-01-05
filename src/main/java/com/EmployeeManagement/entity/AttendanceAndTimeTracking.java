package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "attendance_and_time_tracking")
public class AttendanceAndTimeTracking {
    @Id
    @Column(name = "attendance_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;


//    @OneToMany
//    private List<Employee> employeeId;
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "date_present")
    private LocalDate datePresent;

    @Column(name = "clock_in_time")
    private LocalTime clockInTime;

    @Column(name = "clock_out_time")
    private LocalTime clockOutTime;
}
