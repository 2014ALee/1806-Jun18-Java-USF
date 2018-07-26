package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach, MotivationService {
	private MotivationService motivationService;
	public BaseballCoach() {}
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	@Override
	public String getDailyWorkout() {
		return "Todays' workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseball coach says " + motivationService.getMotivation();
	}
	public void myInitMethod() {
		System.out.println("inside baseball init");
	}
}
