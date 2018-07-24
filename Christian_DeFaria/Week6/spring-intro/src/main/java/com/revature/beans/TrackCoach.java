package com.revature.beans;

import org.springframework.stereotype.Component;

public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Run a thirty minute 5k";
	}

	@Override
	public String getMotivation() {
		// TODO Auto-generated method stub
		return null;
	}

}
