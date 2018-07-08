package com.revature;

import com.revature.models.Bicycle;

public class ExceptionDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("This is the start of ou program...");
		System.out.println("stufffff...");
		
		try {
			Thread.sleep(5000);
			//throw new InterruptedException();
			//throw new OutOfMemoryError();
			//System.exit(0); this will the the app to continue running
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println("This is in the finally block");
		}
		
		System.out.println("This is after the try/catch/finally block");
		
		/* It is possible to have many catch block but always start with the most specific exception 
		 * toward the general exception
		 * 
		 */
		
		Bicycle myBike = new Bicycle();
		System.out.println("Gear: " +myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(24);
		System.out.println("Gear: " +myBike.gear + ", speed: " + myBike.speed);
		
		myBike.speedUp(2);
		System.out.println("Gear: " +myBike.gear + ", speed: " + myBike.speed);
		
	}

}
