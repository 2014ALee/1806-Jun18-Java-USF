package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.services.MotivationService;

@Component("myBaseballCoach")
public class BaseballCoach implements Coach, MotivationService {
	@Autowired
	private MotivationService motivationService;
	public BaseballCoach() {}
	
	public BaseballCoach(MotivationService motivationService) {
		this.motivationService = motivationService;
	}
	@Override
	public String getDailyWorkout() {
		return "Todays' workout: Spend 30 minutes in the batting cage";
	}
	
	@Override
	public String getMotivation() {
		return "The baseball coach says " + motivationService.getMotivation();
	}
	public void myInitMethod() {
		System.out.println("inside baseball init");
	}
}
