package com.revature;

import com.revature.beans.Coach;
import com.revature.beans.TrackCoach;

public class Driver {
	public static void main(String[] args) {
		// Baseball coach - new BaseballCoach();
		Coach coach = new TrackCoach();
		
		System.out.println(coach.getDailyWorkout());
	}
}
