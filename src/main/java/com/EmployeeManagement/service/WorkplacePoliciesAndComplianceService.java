package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.WorkplacePoliciesAndCompliance;
import com.EmployeeManagement.repository.WorkplacePoliciesAndComplianceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkplacePoliciesAndComplianceService {
    @Autowired
    WorkplacePoliciesAndComplianceRepository workplacePoliciesAndComplianceRepository;

    public boolean addPolicyIntoDb(WorkplacePoliciesAndCompliance workplacePoliciesAndCompliance){
        workplacePoliciesAndComplianceRepository.save(workplacePoliciesAndCompliance);
        return true;
    }

    public Boolean updatePolicyFromDb(Integer policyId, WorkplacePoliciesAndCompliance updatedWorkplacePoliciesAndCompliance){
        try {
            WorkplacePoliciesAndCompliance dbPolicy = workplacePoliciesAndComplianceRepository.findById(policyId).get();
            dbPolicy.setPolicyName(
                                    updatedWorkplacePoliciesAndCompliance.getPolicyName()
            );
            dbPolicy.setPolicyDescription(
                                    updatedWorkplacePoliciesAndCompliance.getPolicyDescription()
            );
            dbPolicy.setComplianceStatus(
                                    updatedWorkplacePoliciesAndCompliance.getComplianceStatus()
            );
            workplacePoliciesAndComplianceRepository.save(dbPolicy);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean deletePolicyFromDb(Integer policyId){
        try{
            WorkplacePoliciesAndCompliance dbPolicy = workplacePoliciesAndComplianceRepository.findById(policyId).get();
            workplacePoliciesAndComplianceRepository.deleteById(policyId);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
