package com.revature.models;

public class Bicycle {
	
	public int speed= 0;
	public int gear= 1;
	
	public static String bikeShop = "RevaBikes";
	public static final int MAX_SPEED= 25;
	
	public void getSpeed(int increment) {
		if(this.speed + increment > MAXS_SPEED) {
			speed=25;
			System.out.println("cannot exceed max speed of 25.");
			throw new NegativeSpeedException(); //return;
			
		}else {
			this.speed += decrement; //increment;
			
		}
	}

}
