package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.Position;
import com.EmployeeManagement.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;
    public Position getPositionById(Integer positionId){
        try{
            return positionRepository.findById(positionId).get();
        }catch (Exception e){
            return null;
        }
    }

    public List<Position> getAllPosition(){
        return positionRepository.findAll();
    }

    public List<Position> getPositionByName(String positionName){
        return positionRepository.findByPositionNameLike(positionName);
    }

    public List<Position> getPositionBySalaryRange(Double minimumSalary, Double highestSalary){
        try{
            return positionRepository.findBySalaryRangeBetween(minimumSalary, highestSalary);
        }catch (Exception e){
            return null;
        }
    }
}
