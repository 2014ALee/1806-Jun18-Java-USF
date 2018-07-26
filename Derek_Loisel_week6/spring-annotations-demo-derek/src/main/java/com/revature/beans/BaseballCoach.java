package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach {

	@Autowired
	private MotivationService motivationService;
	
	public BaseballCoach() {}
	
	
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	public void myInitMethod() {
		System.out.println("my init method running");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Today's workout: Spend 30 minutes in the batting cage";
	}
	
	public String getMotivation() {
		return "The baseball coach says: " + motivationService.getMotivation();
	}
}
