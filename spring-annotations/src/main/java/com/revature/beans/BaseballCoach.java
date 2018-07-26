package com.revature.beans;

import com.revature.services.MotivationService;

public class BaseballCoach implements Coach {

	private MotivationService motivationService;

	public BaseballCoach() {};
	

	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}


	@Override
	public String getDailyWorkout() {
		return "Today's workout: spend 30 mins in the batting cage";
	}


	public String getMotivation() {	
		return "The baseball coach says "+motivationService.getMotivation();
	}

}
