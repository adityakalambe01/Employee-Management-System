package com.EmployeeManagement.controller;

import com.EmployeeManagement.entity.HumanResources;
import com.EmployeeManagement.service.HumanResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/HumanResource/")
public class HumanResourceController {
    @Autowired
    HumanResourcesService humanResourcesService;

    @PostMapping("add")
    public String addHrIntoDb(@RequestBody HumanResources hr){
        Integer id = humanResourcesService.addHrIntoDb(hr);
        if(id==null){
            return "Something went wrong";
        }
        return "Your HR id is "+id;
    }

    @PutMapping("{hrId}/update")
    public String updateHrData(@PathVariable Integer hrId,
                               @RequestBody HumanResources browserHumanResources){
        if(
                humanResourcesService.updateHrData(hrId, browserHumanResources)
        ){
            return "Successfully updated HR data having id "+hrId;
        }
        return "Invalid HR Id "+hrId;
    }

    @DeleteMapping("{hrId}/delete")
    public String deleteHrFromDb(@PathVariable Integer hrId){
        if(humanResourcesService.deleteHrFromDb(hrId))
            return "Successfully deleted HR having Id "+hrId;
        return "Invalid HR Id "+hrId;
    }


}
