package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {

	public static void main(String[] args) {
		
		System.out.println("Wake me up in 5000 milliseconds");
		
		// Because Thread.sleep has the throws keyword,
		// we must catch the exception when we call the method
		try {
			Thread.sleep(1);
//			throw new InterruptedException();	// we can throw exceptions ourselves
//			throw new OutOfMemoryError();		// we can also throw errors
//			System.exit(0);						// this immediately ends execution
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// almost always executed
			System.out.println("Finally");
		}
		
		System.out.println("Woke up like this");
		
		// Order matters when catching exceptions.
		// Catch more specific exceptions first.
//		try {
//			throwSomething();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// User-defined exceptions
		Bicycle bike = new Bicycle();
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		bike.speedUp(24);
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		bike.speedUp(2);
		System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		
		try {
			bike.slowDown(26);
		} catch (NegativeSpeedException e) {
			bike.speed = 0;
			e.printStackTrace();
		} finally {
			System.out.println("gear: " + bike.gear + ", speed: " + bike.speed);
		}
	}
	
	// Whenever this method is called, the caller must deal with the possibility of the exception.
	public static void throwSomething() throws IOException {
		System.out.println("This might throw an exception");
	}

}
