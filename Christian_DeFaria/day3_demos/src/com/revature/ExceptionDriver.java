package com.revature;

import java.io.IOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {
	public static void main(String[] args) {
			System.out.println("This is the start of our program...");
			System.out.println("Stuffff.......");
			
			try {
				Thread.sleep(1000L);
//				throw new InterruptedException();
//				throw new OutOfMemoryError();
//				System.exit(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.println("This is in the finally block");
			}
			
			System.out.println("This is after the try/catch/finally blocks");
			
			//Out of order catch blocks create unreachable code
//			try {
//				throwSomething();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			Bicycle myBike = new Bicycle();
			System.out.println("Gear: " + myBike.gear + ", Speed: " + myBike.speed);
			
			myBike.speedUp(24);
			System.out.println("Gear: " + myBike.gear + ", Speed: " + myBike.speed);
			
			myBike.speedUp(2);
			System.out.println("Gear: " + myBike.gear + ", Speed: " + myBike.speed);
			
			try {
				myBike.slowDown(26);
			} catch (NegativeSpeedException e) {
				// TODO Auto-generated catch block
				myBike.speed = 0;
				e.printStackTrace();
			}
			System.out.println("Gear: " + myBike.gear + ", Speed: " + myBike.speed);
	}
	
	//Include a throws clause on a method signature to force calling methods to handle the exception
	public static void throwSomething() throws IOException {
		System.out.println("This method might throw an exception");
	}
}
