package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {
	private MotivationService motivationService;
	
	public BaseballCoach() {
		System.out.println("[debug] - inside baseballcoach() no-args constructor");
	}
	
	public BaseballCoach(MotivationService motivationService) {
		System.out.println("[debug] - inside baseballcoach contructor");
		this.motivationService = motivationService;
	}
	
	// no parameters
	public void myInitMethod() {
		System.out.println("[Debug] - Inside BaseballCoach.myInitMethod()");
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
