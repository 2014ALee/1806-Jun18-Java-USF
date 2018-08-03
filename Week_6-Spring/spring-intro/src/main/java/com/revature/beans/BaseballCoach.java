package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {
	
	private MotivationService motivationService;
	
	public BaseballCoach() {
		System.out.println("[DEBUG] - Inside BaseballCoach no-arg constructor");
	}
	
	public BaseballCoach(MotivationService motivatonService) {
		System.out.println("[DEBUG] - Inside BaseballCoach constructor");
		this.motivationService = motivatonService;
	}
	
	public void myInitMethod() {
		System.out.println("[DEBUG] - Inside BaseballCoach.myInitMethod()");
	}

	@Override
	public String getDailyWorkout() {
		return "Todays' workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseball coach says: " + motivationService.getMotivation();
	}
	
}
