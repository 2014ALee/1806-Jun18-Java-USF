package com.revature.beans;

import com.revature.services.MotivationService;

public class TrackCoach implements Coach{

	private MotivationService motivationService;
	
	public TrackCoach() {}
	
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motiv
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run 5k";
	}
	
	@Override
	public String getMotivation() {
		return "motivation";
	}
	
	
}
