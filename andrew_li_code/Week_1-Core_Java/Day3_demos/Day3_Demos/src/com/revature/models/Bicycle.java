package com.revature.models;

import com.revature.exceptions.NegativeSpeedException;

public class Bicycle {
	private int speed;
	private int gear;
	
	public static String bikeShop = "RevaBikes";
	public static final int MAX_SPEED = 25;
	public static int MIN_SPEED = 0;
	
	public Bicycle(int speed, int gear) {
		super();
		setSpeed(speed);
		setGear(gear);
	}

	public void speedUp(int increment) {
		setSpeed(this.speed + increment);
	}
	
	public void slowDown(int decrement) throws NegativeSpeedException {
		if (this.speed < decrement) {
			throw new NegativeSpeedException();
		}
		setSpeed(this.speed - decrement);
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		if (speed > MAX_SPEED) {
			this.speed = MAX_SPEED;
			return;
		} else if (speed < MIN_SPEED) {
			this.speed = MIN_SPEED;
			return;
		}
		this.speed = speed;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public static String getBikeShop() {
		return bikeShop;
	}

	public static void setBikeShop(String bikeShop) {
		Bicycle.bikeShop = bikeShop;
	}
	
	public String toString() {
		return "_______________________\n\nGear: " + this.gear + "\nSpeed: " + this.speed + "\n_______________________"; 
	}
	
}
