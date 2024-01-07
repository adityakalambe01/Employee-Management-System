package com.EmployeeManagement.service;

import com.EmployeeManagement.entity.HumanResources;
import com.EmployeeManagement.repository.HumanResourcesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanResourcesService {
    @Autowired
    HumanResourcesRepository humanResourcesRepository;
    public Integer addHrIntoDb(HumanResources humanResources){
        return humanResourcesRepository.save(humanResources).getHrId();
    }

    public boolean updateHrData(Integer hrId, HumanResources browserHumanResources){
        try {
            HumanResources dbHumanResources = humanResourcesRepository.findById(hrId).get();
            dbHumanResources.setEmployeeId(browserHumanResources.getEmployeeId());
            dbHumanResources.setHrTitle(browserHumanResources.getHrTitle());

            humanResourcesRepository.save(dbHumanResources);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public Integer getHrId(Integer employeeId){
        return humanResourcesRepository.findByEmployeeId(employeeId);
    }

    public Boolean deleteHrFromDb(Integer hrId){
        try {
            HumanResources dbHumanResource = humanResourcesRepository.findById(hrId).get();
            humanResourcesRepository.delete(dbHumanResource);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public String getHrTitle(Integer hrId){
        return humanResourcesRepository.findByHrTitle(hrId);
    }
}
