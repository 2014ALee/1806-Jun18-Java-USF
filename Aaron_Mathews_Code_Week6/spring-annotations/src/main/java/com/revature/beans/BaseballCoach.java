package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach {
	
	private MotivationService motivationService;
	
	public BaseballCoach() {}
	
	public void myInitMethod() {
		System.out.println("Inside BaseballCoach.myInitMethod()");
	}
	
	@Autowired
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Today's workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseball coach says: " + motivationService.getMotivation();
	}

}
