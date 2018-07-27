package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component
public class TrackCoach implements Coach {
	@Autowired
	private MotivationService motivationService;
	
	public TrackCoach() { }
	
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a 30 minute 5K";
	}

	@Override
	public String getMotivation() {
		return "The track coach says: " + motivationService.getMotivation();
	}
	
	

}
