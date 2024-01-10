package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.WorkplacePoliciesAndCompliance;
import com.EmployeeManagement.service.WorkplacePoliciesAndComplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/WorkplacePoliciesAndCompliance/")
public class WorkplacePoliciesAndComplianceController {
    @Autowired
    WorkplacePoliciesAndComplianceService workplacePoliciesAndComplianceService;

    @PostMapping("add/policy")
    public boolean addPolicyIntoDb(@RequestBody WorkplacePoliciesAndCompliance workplacePoliciesAndCompliance){
        return workplacePoliciesAndComplianceService.addPolicyIntoDb(workplacePoliciesAndCompliance);
    }

    @PutMapping("update/policy/id{policyId}")
    public Boolean updatePolicyFromDb(@PathVariable Integer policyId,
                                      @RequestBody WorkplacePoliciesAndCompliance updatedWorkplacePoliciesAndCompliance){
        return workplacePoliciesAndComplianceService.updatePolicyFromDb(policyId, updatedWorkplacePoliciesAndCompliance);
    }

    @DeleteMapping("delete/policy/id/{policyId}")
    public Boolean deletePolicyFromDb(@PathVariable Integer policyId){
        return workplacePoliciesAndComplianceService.deletePolicyFromDb(policyId);
    }
}
