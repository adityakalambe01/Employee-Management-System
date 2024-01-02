package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_ms_position")
public class Position {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name = "salary_range")
    private Double salaryRange;

    @Column(name = "minimum_salary")
    private Double minimumSalary;

    @Column(name = "highest_salary")
    private Double highestSalary;
}
