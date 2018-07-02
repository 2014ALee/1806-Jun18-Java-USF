package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {

	public static void main(String[] args) {
		System.out.println("This is the start of our program...");
		System.out.println("Stufffff......");
		
		try {
			Thread.sleep(5000);
//			throw new InterruptedException();			// we can throw exceptions ourselves
//			throw new OutOfMemoryError();				// we can also throw errors
//			System.exit(0);								// this will halt the app. Nothing after this is executed
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}finally {										// is still executed if an uncaught exception occurs
			System.out.println("This is in the finally block!");
		}
		
		System.out.println("This is after the try/catch/finally blocks.");
		
//		try{
//			throwsSomething();
//		}catch(IOException ioe) {
//			ioe.printStackTrace();
//		}
	
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
	
	// Include a throws clause on a method's signature to force any calling method to handle it.
	// Also known as throwing or propagating
	public static void throwsSomething() throws IOException {
		System.out.println("This method might throw an exeption");
	}
	
}
