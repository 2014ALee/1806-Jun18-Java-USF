package com.revature.beans;

import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myFootballCoach")
public class FootballCoach implements Coach {

	
	private String email;
	private String team;
	private MotivationService motivationService;
	
	public FootballCoach() {
		System.out.println("debug - inside football coach no arg constructor");
	}
	
	public FootballCoach(MotivationService motivationService) {
		System.out.println("debug - inside football coach motivation service constructor");
		this.motivationService = motivationService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "todays workout= suicide runs";
	}

	@Override
	public String getMotivation() {
		return "more motivation yo";
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
		this.motivationService = motivationService;
	}

	
	
}
