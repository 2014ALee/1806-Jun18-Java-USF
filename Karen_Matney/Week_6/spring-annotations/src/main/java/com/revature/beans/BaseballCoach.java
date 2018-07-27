package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach {
	@Autowired
	private MotivationService motivationService;
	
	public BaseballCoach() {
		System.out.println("[debug] - inside baseballcoach() no-args constructor");
	}
	
	public BaseballCoach(MotivationService motivationService) {
		System.out.println("[debug] - inside baseballcoach contructor");
		this.motivationService = motivationService;
	}
	
	// no parameters
	public void myInitMethod() {
		System.out.println("[Debug] - Inside BaseballCoach.myInitMethod()");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Today's workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseball coach says: " + motivationService.getMotivation();
	}
}
