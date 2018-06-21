package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {

	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stuff...");
		
		
		try {
			Thread.sleep(5000);
			
			//Throw new InterruptedException();    we can throw exceptions ourselves
			//we can also throw errors (no need)
			//we can also do System.exit(0)
			
		} catch (InterruptedException e) {
		e.printStackTrace();
		} finally {
			System.out.println("This is in the finally block!");
		}
		
		System.out.println("This is after the try catch finally blocks");
		
		Bicycle myBike = new Bicycle();
		System.out.println("gear: " + myBike.gear + ", speed:" + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + ", speed:" + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + ", speed:" + myBike.speed);
		
		try {
			myBike.slowDown(26);
		} catch (NegativeSpeedException e) {
			myBike.speed=0;
			e.printStackTrace();
		}
		
	}
		
	//Order of catch blocks matters! Catch exceptions starting with the most specific!	
	//	try {
		//	throwSomething();
		//} catch (Exception e) {
		//	e.printStackTrace();
//		} catch (IOException e) {
		//	e.printStackTrace();
	//	}
//	}
	
			
	//Include a throws clause on a method's signature to force any calling method to handle it.
	//Also known as throwing or propagating.
	public static void throwSomething() throws IOException {
		System.out.println("This method might throw an exception");
		
	}
	
	
	
}
