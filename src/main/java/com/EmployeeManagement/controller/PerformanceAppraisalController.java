package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.PerformanceAppraisal;
import com.EmployeeManagement.service.PerformanceAppraisalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/PerformanceAppraisal/")
public class PerformanceAppraisalController {
    @Autowired
    PerformanceAppraisalService performanceAppraisalService;
    @PostMapping("addPerformance")
    public boolean addPerformance(@RequestBody PerformanceAppraisal performanceAppraisal){
        return performanceAppraisalService.addPerformance(performanceAppraisal);
    }

    @PutMapping("id/{appraisalID}/update")
    public String updatePerformance(@PathVariable Integer appraisalID,
                                     @RequestBody PerformanceAppraisal updatedPerformanceAppraisal){
        if (
                performanceAppraisalService.updatePerformance(appraisalID,updatedPerformanceAppraisal)
        ){
            return "Successfully updated Appraisal ID "+appraisalID;
        }
        return "Invalid Appraisal ID "+appraisalID;
    }

    @DeleteMapping("id/{appraisalID}/delete")
    public String deletePerformance(@PathVariable Integer appraisalID){
        if (
                performanceAppraisalService.deletePerformance(appraisalID)
        ){
            return "Successfully deleted "+appraisalID;
        }
        return "invalid Appraisal ID"+appraisalID;
    }

    @GetMapping("allbetween/lowestrating/{initialRating}/highestrating/{highestRating}/ofmonth/{month}/andyear/{year}")
    public List getRatingsBetweenRange(@PathVariable Double initialRating,
                                       @PathVariable Double highestRating,
                                       @PathVariable String month,
                                       @PathVariable String year){

        return performanceAppraisalService.getRatingsBetweenRange(initialRating, highestRating, month, year);
    }
}
