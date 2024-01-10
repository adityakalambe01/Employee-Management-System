package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.TrainingAndDevelopment;
import com.EmployeeManagement.repository.TrainingAndDevelopmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingAndDevelopmentService {
    @Autowired
    TrainingAndDevelopmentRepository trainingAndDevelopmentRepository;
    public Integer addTrainingAndDevelopment(TrainingAndDevelopment tad){
        return trainingAndDevelopmentRepository.save(tad).getTrainingId();
    }

    public Boolean updateTrainingAndDevelopment(Integer trainingId, TrainingAndDevelopment trainingAndDevelopment){
        try {
            TrainingAndDevelopment tdObj = trainingAndDevelopmentRepository.findById(trainingId).get();
            tdObj.setTrainingName(
                    trainingAndDevelopment.getTrainingName()
            );
            tdObj.setEmployeeId(
                    trainingAndDevelopment.getEmployeeId()
            );
            tdObj.setTrainingDuration(
                    trainingAndDevelopment.getTrainingDuration()
            );
            tdObj.setTrainingDate(
                    trainingAndDevelopment.getTrainingDate()
            );
            trainingAndDevelopmentRepository.save(tdObj);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Boolean deleteTrainingAndDevelopment(Integer trainingId){
        try {
            trainingAndDevelopmentRepository.deleteById(
                    trainingAndDevelopmentRepository.findById(trainingId)
                            .get()
                            .getTrainingId()
            );
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public List<TrainingAndDevelopment> getAllTrainings(){
        return trainingAndDevelopmentRepository.findAll();
    }

    public TrainingAndDevelopment getInfo(Integer trainingId){
        try{
            return trainingAndDevelopmentRepository.findById(trainingId).get();
        }catch (Exception e){
            return null;
        }
    }

    public List<TrainingAndDevelopment> listOfTrainingUsingEmployeeId(Integer employeeID){
        return trainingAndDevelopmentRepository.findAllByEmployeeId(employeeID);
    }

    public Boolean addEmployeeInTraining(List<Integer> employeeList){
        return null;
    }

    public Boolean deleteAllTrainingRecordsWithTrainingId(Integer trainingId){
        return null;
    }
}
