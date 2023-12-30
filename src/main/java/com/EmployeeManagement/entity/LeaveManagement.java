package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_ms_leave_management")
public class LeaveManagement {
    @Id
    @Column(name = "leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "leave_type")
    private Integer leaveType;

    @Column(name = "start_date")
    private LocalDate leaveStartDate;

    @Column(name = "end_date")
    private LocalDate leaveEndDate;

    @Column(name = "status")
    private String leaveStatus;

}
