package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.PerformanceAppraisal;
import com.EmployeeManagement.repository.PerformanceAppraisalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerformanceAppraisalService {
    @Autowired
    PerformanceAppraisalRepository performanceAppraisalRepository;

    public boolean addPerformance(PerformanceAppraisal performanceAppraisal){
        performanceAppraisalRepository.save(performanceAppraisal);
        return true;
    }

    public boolean updatePerformance(Integer appraisalID, PerformanceAppraisal updatedPerformanceAppraisal){
        try {
            PerformanceAppraisal performanceAppraisal = performanceAppraisalRepository.findById(appraisalID).get();
            performanceAppraisal.setEmployeeId(
                    updatedPerformanceAppraisal.getEmployeeId()
            );
            performanceAppraisal.setAppraisalComment(
                    updatedPerformanceAppraisal.getAppraisalComment()
            );
            performanceAppraisal.setAppraisalDate(
                    updatedPerformanceAppraisal.getAppraisalDate()
            );
            performanceAppraisal.setRating(
                    updatedPerformanceAppraisal.getRating()
            );
            performanceAppraisalRepository.save(performanceAppraisal);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
