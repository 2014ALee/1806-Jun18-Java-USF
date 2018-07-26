package com.revature.beans;

import com.revature.services.MotivationService;

public class FootballCoach implements Coach {

	private String email;
	private String team;
	private MotivationService motivationService;

	public FootballCoach() {
		System.out.println("debug - in football coach no arg const");

	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getTeam() {
		return team;
	}




	public void setTeam(String team) {
		this.team = team;
	}




	public MotivationService getMotivationService() {
		return motivationService;
	}




	public void setMotivationService(MotivationService motivationService) {
		System.out.println("debug - in footballCoach.setMotivationService");
		this.motivationService = motivationService;
	}




	@Override
	public String getDailyWorkout() {
		
		return "Today's workout: Go get some touchdowns";
	}

	@Override
	public String getMotivation() {
		
		return "The football coach says: " + motivationService.getMotivation();
	}

}
