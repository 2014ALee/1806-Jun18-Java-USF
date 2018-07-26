package com.revature;

import com.revature.beans.BaseballCoach;
import com.revature.beans.Coach;
import com.revature.beans.TrackCoach;

public class Driver {

	public static void main(String[] args) {
		
		Coach coach = new TrackCoach();
		
		System.out.println(coach.getDailyWorkout());
		
	}
	
}
