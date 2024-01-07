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
@Table(name="employees")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "address")
    private String address;

    @Column(name = "joining_date")
    private LocalDate joiningDate;

    @Column(name = "department_id")
//    @ManyToOne
    private Integer departmentId;

    @Column(name = "position_id")
    private Integer positionId;

    @Column(name = "salary")
    private Double salary;


}
