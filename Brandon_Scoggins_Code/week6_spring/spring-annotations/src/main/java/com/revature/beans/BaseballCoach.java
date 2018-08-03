package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach {

//	@Autowired
	private MotivationService motivationService;

	public BaseballCoach() {
		
	}
	
	@Autowired	// this can go on the method or the field or a setter
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	public void myInitMethod() {
		System.out.println("[DEBIG] - in BaseballCoach myInitMethod()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Todays' workout: Spend 30min in the batting cage.";
	}

	@Override
	public String getMotivation() {
		return "Baseball coach says: " + motivationService.getMotivation();
	}
}
