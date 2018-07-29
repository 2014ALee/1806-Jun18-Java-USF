package com.revature.beans;

import com.revature.services.MotivationService;

public class FootballCoach implements Coach {
	
	private String email;
	private String team;
	private MotivationService motivationService;
	
	public FootballCoach() {
		System.out.println("[DEBUG] - Inside FootballCoach no-arg constructor");
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
		System.out.println("[DEBUG] - Inside FootballCoach.setMotivationService()");
		this.motivationService = motivationService;
	}

	@Override
	public String getDailyWorkout() {
		return "Today's workout: Do suicide runs to 40, 60, 80, and endzone";
	}

	@Override
	public String getMotivation() {
		return "The football coach says: " + motivationService.getMotivation();
	}

}
