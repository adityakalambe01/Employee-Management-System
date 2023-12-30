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
@Table(name = "emp_ms_performance_appraisal")
public class PerformanceAppraisal {
    @Id
    @Column(name = "appraisal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appraisalID;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "appraisal_date")
    private LocalDate appraisalDate;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "appraisal_comment")
    private String appraisalComment;
}
