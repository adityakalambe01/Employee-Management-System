package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @ElementCollection
    @CollectionTable(name = "emp_ms_team_managed", joinColumns = @JoinColumn(name = "manager_id"))
    @Column(name = "employee_id")
    private List<Long> teamManaged;
}
