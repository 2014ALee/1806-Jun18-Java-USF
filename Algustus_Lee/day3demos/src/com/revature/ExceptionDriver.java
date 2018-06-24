package com.revature;

import java.io.IOException;

import com.revature.exception.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {
	public static void main(String[] args)
	{
		System.out.println("This is the start of our program...");
		System.out.println("Stuffffffffffffffffff...");
		
		try {
			Thread.sleep(1000);
			//throw new InterruptedException(); You can use the 'throw' keyword to automatically call an error or exception.
			//throw new OutOfMemoryError();
			//System.exit(0); this causes the program to stop.
		} catch (InterruptedException ie) {
			// TODO Auto-generated catch block
			ie.printStackTrace();
		}
		finally {
			//will almost always be executed.
			System.out.println("Finally, we see what's in the finally block.");
		}
		System.out.println("This is outside of the finally block.");
		
		//Order is important, do the most specific exceptions first, then go down to the more generic ones.
		/*try {
			throwSomething();
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}*/
		
		Bicycle myBike = new Bicycle();
		System.out.println("gear: "+myBike.gear + " , speed: " +myBike.speed);
		
		myBike.speedUp(25);
		System.out.println("gear: "+myBike.gear + " , speed: " +myBike.speed);
		
		try {
			myBike.slowDown(26);
		} catch (NegativeSpeedException e) {
			myBike.speed = 0;
			e.printStackTrace();
		}
		System.out.println("gear: "+myBike.gear + " , speed: " +myBike.speed);
	}
	
	//Include a throws clause on a method's signature to force any calling method to check for exceptions.
	public static void throwSomething() throws Exception{
		System.out.println("This method might throw an exception.");
	}

}
