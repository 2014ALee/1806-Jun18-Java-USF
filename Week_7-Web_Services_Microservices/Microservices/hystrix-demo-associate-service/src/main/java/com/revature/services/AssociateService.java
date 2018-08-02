package com.revature.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AssociateService {
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	@Autowired
    RestTemplate restTemplate;
     
    @HystrixCommand(fallbackMethod = "getBatchData_fallback")
    public String getBatchData(String trainingBatchId) {
 
        System.out.println("Getting batch details for " + trainingBatchId);
 
        String response = restTemplate.exchange("http://localhost:8098/" + trainingBatchId + "/associates", HttpMethod.GET, null, 
        		new ParameterizedTypeReference<String>() {}, trainingBatchId).getBody();
 
        System.out.println("Response Received as " + response + " -  " + new Date());
 
        return "Batch Name - " + trainingBatchId + " ::: Associate Details " + response + " - " + new Date();
    }
     
    @SuppressWarnings("unused")
    private String getBatchData_fallback(String schoolname) {
 
        System.out.println("Batch Service is temporarily down! Fallback route enabled...");
 
        return "CIRCUIT BREAKER ENABLED! No Response From Batch Service at this moment. " +
                    " Service will be back shortly - " + new Date();
    }
 
}
