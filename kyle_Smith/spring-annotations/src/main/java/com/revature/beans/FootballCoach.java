package com.revature.beans;

import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myFootballCoach")
public class FootballCoach implements Coach{

	private String email;
	private String team;
	private MotivationService motivationService;
	
	public FootballCoach() {System.out.println("{debug} inside football no-args");}
	
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
		System.out.println("{debug} inside football setMotivation");
		this.motivationService = motivationService;
	}

	@Override
	public String getDailyWorkout() {
		return "Todays workout: Do suicide runs to 40, 60, 80, and endzone";
	}

	@Override
	public String getMotivation() {
		return "the football coach says: " + motivationService.getMotivation();
	}

}
