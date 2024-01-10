package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.TrainingAndDevelopment;
import com.EmployeeManagement.service.TrainingAndDevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/TrainingAndDevelopment/")
public class TrainingAndDevelopmentController {
    @Autowired
    TrainingAndDevelopmentService trainingAndDevelopmentService;

    @PostMapping("add/training")
    public String addTraining(@RequestBody TrainingAndDevelopment tad){
        return "The training id is "+trainingAndDevelopmentService.addTrainingAndDevelopment(tad);
    }

    @PutMapping("update/training/id/{trainingId}")
    public String updateTrainingRecord(@PathVariable Integer trainingId,
                                       @RequestBody TrainingAndDevelopment updatedTraining){
        return trainingAndDevelopmentService.updateTrainingAndDevelopment(trainingId,updatedTraining) ?
                "Successfully updated training record" :
                "Invalid training id "+trainingId;
    }

    @DeleteMapping("delete/training/id/{trainingId}")
    public String deleteTrainingRecord(@PathVariable Integer trainingId){
        return (trainingAndDevelopmentService.deleteTrainingAndDevelopment(trainingId)) ?
                "Successfully deleted the training record having id "+trainingId :
                "Invalid training id "+trainingId;
    }

    @GetMapping("all/training/records")
    public List<TrainingAndDevelopment> getAllTrainings(){
        return trainingAndDevelopmentService.getAllTrainings();
    }

    @GetMapping("information/training/id{trainingId}")
    public String getInfo(@PathVariable Integer trainingId){
        TrainingAndDevelopment object = trainingAndDevelopmentService.getInfo(trainingId);
        String outputString;
        if (object==null){
            outputString = "Invalid training id "+trainingId;
        }else {
            outputString = "Training Id : "+object.getTrainingId()+
                    "\nEmployee Id : "+object.getEmployeeId() +
                    "\nTraining Name : "+object.getTrainingName() +
                    "\nTraining Duration : "+object.getTrainingDuration() +
                    "\nTraining Date : "+object.getTrainingDate();
        }
        return outputString;
    }

    @GetMapping("list/training/employee/id{employeeID}")
    public List<TrainingAndDevelopment> listOfTrainingUsingEmployeeId(@PathVariable Integer employeeID){
        return trainingAndDevelopmentService.listOfTrainingUsingEmployeeId(employeeID);
    }


}
