package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

	
	private MotivationService motivationService;

	public BaseballCoach() {
		
	}
	
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
