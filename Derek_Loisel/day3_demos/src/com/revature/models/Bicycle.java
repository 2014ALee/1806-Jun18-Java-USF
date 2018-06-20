package com.revature.models;

import com.revature.exceptions.NegativeSpeedException;

public class Bicycle {

	public int speed = 0;
	public int gear = 1;
	
	public static String bikeShop = "RevaBikes";	
	public static final int MAX_SPEED = 25;
	
	public void speedUp(int increment) {
		if (this.speed + increment > MAX_SPEED) {
			speed = 25;
			System.out.println("Can't exceed max speed of 25.");
			return;
		}else {
			this.speed += increment;
		}
	}
	
	public void slowDown (int decrement) throws NegativeSpeedException {
		if (this.speed - decrement < 0) {		
			
			throw new NegativeSpeedException();	
			
		}else {
			this.speed -= decrement;
		}
	}
}
