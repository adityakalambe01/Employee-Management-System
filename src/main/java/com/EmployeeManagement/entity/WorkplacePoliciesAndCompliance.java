package com.EmployeeManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "workplace_policies_and_compliance")
public class WorkplacePoliciesAndCompliance {
    @Id
    @Column(name = "policy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer policyId;

    @Column(name = "policy_name")
    private String policyName;

    @Column(name = "description")
    private String policyDescription;

    @Column(name = "compliance_status")
    private Boolean complianceStatus;
}
