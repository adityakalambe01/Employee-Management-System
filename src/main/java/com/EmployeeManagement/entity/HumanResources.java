package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emp_ms_hr")
public class HumanResources {
    @Id
    @Column(name = "hr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hrId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "hr_title")
    private String hrTitle;
}
