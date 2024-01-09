package com.EmployeeManagement.service;


import com.EmployeeManagement.entity.PerformanceAppraisal;
import com.EmployeeManagement.repository.PerformanceAppraisalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

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

    public boolean deletePerformance(Integer appraisalID){
        try {
            PerformanceAppraisal performanceAppraisal = performanceAppraisalRepository.findById(appraisalID).get();
            performanceAppraisalRepository.delete(performanceAppraisal);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List getRatingsBetweenRange(Double initialRating, Double highestRating, String month, String year){

        String[] monthArray = {"01","02","03","04","05","06","07","08","09","10","11","12"};
        int index = Integer.parseInt(month);
        String date = monthArray[index]+"/"+year;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth yearMonth = YearMonth.parse(date, dateFormat);
        LocalDate browserDate = yearMonth.atDay(1);
        System.out.println(browserDate);

        return performanceAppraisalRepository.findByRatingBetween(initialRating,
                                                                  highestRating,
                                                                  browserDate.with(
                                                                          TemporalAdjusters.firstDayOfMonth()
                                                                  ),
                                                                  browserDate.with(
                                                                          TemporalAdjusters.lastDayOfMonth()
                                                                  )
        );
    }
}
