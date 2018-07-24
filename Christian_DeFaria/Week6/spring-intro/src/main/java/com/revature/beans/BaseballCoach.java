package com.revature.beans;

import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {
	
	private MotivationService motivationService;
	
	public BaseballCoach() {
		System.out.println("[DEBUG] - in BaseballCoach no-arg constructor");
	}
	
	public BaseballCoach(MotivationService ms) {
		System.out.println("[DEBUG] - in BaseballCoach constructor");
		this.motivationService = ms;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Todays' workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "Baseball coach says: " + motivationService.getMotivation();
	}
	
	public void myInitMethod() {
		System.out.println("[DEBUG] - in myInitMethod");
	}

}
