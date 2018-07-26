package com.revature.beans;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach{

	private MotivationService motivationService;
	public TrackCoach() {}
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run a 30 minute 5k";
		
	}

	@Override
	public String getMotivation() {
		return " the track coach says " + motivationService.getMotivation();
	}

}
