package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "leave_management")
public class LeaveManagement {
    @Id
    @Column(name = "leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveId;

    @Column(name = "employee_id")
//    @OneToMany
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
