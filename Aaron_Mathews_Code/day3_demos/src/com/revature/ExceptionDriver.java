package com.revature;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

import java.io.IOException;

public class ExceptionDriver {

	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stufff........");
		
		try {
			Thread.sleep(1000);
			//throw new InterruptedException();
			//throw new OutOfMemoryError();
			//System.exit(0);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			System.out.println("Finally.");
		}
		System.out.println("After try-catch block");
		
		try {
			throwSomething();
		} 
		//Catches must be most specific to most general
//			catch (Exception) {
//		} 
		catch (IOException e) {			
			e.printStackTrace();
		}
		
		Bicycle myBike = new Bicycle();
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		try {
			myBike.slowDown(26);
		} catch (NegativeSpeedException e) {
			myBike.speed = 0;
			e.printStackTrace();
		}
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);

	}
	
	public static void throwSomething() throws IOException{
		System.out.println("This method might throw an exception");
	}

}
