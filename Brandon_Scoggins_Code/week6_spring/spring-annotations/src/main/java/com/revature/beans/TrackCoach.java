package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component 	// leaving name blank lets spring use the class name with the first letter lowercased to identify this bean
public class TrackCoach implements Coach{
	
	@Autowired
	private MotivationService motivationService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a 5k";
	}

	@Override
	public String getMotivation() {
		return "Track coach says: " + motivationService.getMotivation();
	}

}
