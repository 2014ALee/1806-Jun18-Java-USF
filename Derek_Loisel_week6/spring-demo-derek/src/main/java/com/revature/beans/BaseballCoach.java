package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

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
