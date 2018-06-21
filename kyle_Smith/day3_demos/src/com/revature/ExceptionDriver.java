package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {

	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stufffffffffff..................");
		
		try {
			Thread.sleep(40);
//			throw new InterruptedException(); we can throw exceptions ourselves
//			throw new OutofMemoryError();	we can also throw errors (but why?)
//			System.exit(0);	this will halt the app, nothing past this line will be executed
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("This is the finally block!");
		}
		System.out.println("this is after the try/catch/finaly blocks.");
		
		
		//Order of catch blows matters! Catch eceptions starting with the most specific!
		try {
			throwSomething();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			myBike.speed = 0;
			e.printStackTrace();
		}
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
	}
	
	// Include a throws clause on a method's signature to force any calling method to handle it.
	// Also known as throwing or propagating.
	public static void throwSomething() throws IOException {
		System.out.println("this method might throw an exception");
	}
}
