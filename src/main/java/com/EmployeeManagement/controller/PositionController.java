package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.Position;
import com.EmployeeManagement.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/position/")
public class PositionController {
    @Autowired
    PositionService positionService;

    @GetMapping("getby/id/{positionId}")
    public Position getPositionById(@PathVariable Integer positionId){
        return positionService.getPositionById(positionId);
    }

    @GetMapping("getallpositions")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("getpositionby/name/{positionName}")
    public List<Position> getPositionByName(@PathVariable String positionName){
        return positionService.getPositionByName(positionName);
    }

    @GetMapping("allpositionbetween/salary/minimumsalary/{minimumSalary}/between/highestsalary/{highestSalary}")
    public List<Position> getPositionBySalaryRange(@PathVariable Double minimumSalary,
                                                   @PathVariable Double highestSalary){
        return positionService.getPositionBySalaryRange(minimumSalary, highestSalary);
    }
}
