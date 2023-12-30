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
@Table(name = "emp_ms_training_and_development")
public class TrainingAndDevelopment {
    @Id
    @Column(name = "training_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainingId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "training_name")
    private String trainingName;

    @Column(name = "training_date")
    private LocalDate trainingDate;

    @Column(name = "duration")
    private Integer trainingDuration;
}
