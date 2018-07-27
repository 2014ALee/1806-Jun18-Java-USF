package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {
	
	private MotivationService motivationService;
	
	public BaseballCoach() {}
	
	public void myInitMethod() {
		System.out.println("Inside BaseballCoach.myInitMethod()");
	}
	
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Today's workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseballe coach says: " + motivationService.getMotivation();
	}

}
