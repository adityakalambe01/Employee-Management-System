package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_ms_salary_and_compensation")
public class SalaryAndCompensation {
    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salaryId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "base_salary")
    private Double baseSalary;

    @Column(name = "bonuses")
    private Double bonuses;

    @Column(name = "benefits")
    private String benefits;
}
