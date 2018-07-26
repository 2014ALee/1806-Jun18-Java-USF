package com.revature;

import com.revature.beans.BaseballCoach;
import com.revature.beans.Coach;
import com.revature.beans.TrackCoach;

public class Driver {

	public static void main(String[] args) {
		
		//BaseballCoach coach = new BaseballCoach();
		Coach coach = new BaseballCoach();
		Coach coach2 = new TrackCoach();
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach2.getDailyWorkout());
	}
}
