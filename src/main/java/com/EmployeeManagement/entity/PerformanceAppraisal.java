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
@Table(name = "performance_appraisal")
public class PerformanceAppraisal {
    @Id
    @Column(name = "appraisal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appraisalID;

    @Column(name = "employee_id")
//    @OneToMany
    private Integer employeeId;

    @Column(name = "appraisal_date")
    private LocalDate appraisalDate;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "appraisal_comment")
    private String appraisalComment;
}
