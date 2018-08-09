package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AssociateService;

@RestController
public class AssociateController {
     
    @Autowired
    AssociateService associateService;
 
    @GetMapping(value = "/associate/{trainingBatchId}")
    public String getStudents(@PathVariable String trainingBatchId) {
        System.out.println("Calling batch service to get data...");
        return associateService.getBatchData(trainingBatchId);
    }
}
