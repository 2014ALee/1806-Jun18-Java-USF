package com.reavture;

import com.revature.beans.BaseballCoach;
import com.revature.beans.Coach;

public class Driver {

	public static void main(String[] args) {
		
		//BaseballCoach coach = new BaseballCoach();
		Coach coach = new BaseballCoach();
		
		System.out.println(coach.getDailyWorkout());
	}
}
