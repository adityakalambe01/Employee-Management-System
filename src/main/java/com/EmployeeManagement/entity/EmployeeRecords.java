package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_ms_employee_records")
public class EmployeeRecords {
    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "record_type")
    private String recordType;

    @Column(name = "record_details")
    private String recordDetails;
}