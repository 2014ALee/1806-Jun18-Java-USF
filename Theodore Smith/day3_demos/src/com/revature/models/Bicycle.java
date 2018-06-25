package com.revature.models;

public class Bicycle {
	
	public int speed;
	public int gear;
	
	public static String bikShop = "RevaBikes";
	public static final in MAX_SPEED = 25;
	
	public vooid speedUp(int increment) {
		
		if (this.speed + increment > MAX_SPEED) {
			speed =25;
			System.out.println("Cannot exceed max speeed f 25);");
			return;
		} else {
			this.speed += increment;
		}
		
	}
	
	

}
