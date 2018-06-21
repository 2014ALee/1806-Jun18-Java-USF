package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {
	
	public static void main(String[] args) {
		
		System.out.println("This is the start of our program...");
		System.out.println("Stufffff....");
		
		try {
		Thread.sleep(1000);
//		throw new InterruptedException(); //we can throw exceptions ourselves
		}catch (InterruptedException ie) {
			ie.printStackTrace();
		}finally {
			System.out.println("This is in the finally block");
		}
		
		System.out.println("after finally block");
		
		
		Bicycle myBike = new Bicycle();
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);
		
		try {
			myBike.slowDown(26);
		}catch (NegativeSpeedException e) {
			myBike.speed = 0;
			e.printStackTrace();
		}
		
		System.out.println("gear: " + myBike.gear + ", speed: " + myBike.speed);

		
	}
	
	//Include throws clause on a method's signature to force any calling method to handle it.
	//Also known as throwing or propagating
	public static void throwSomething() throws IOException{
		System.out.println("this method might throw an exception");
	}
	
}
