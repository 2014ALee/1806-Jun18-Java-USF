package com.revature;

import java.io.InterruptedIOException;

import com.revature.exceptions.NegativeSpeedException;
import com.revature.models.Bicycle;

public class ExceptionDriver {
	public static void main(String[] args) {
		System.out.println("This is the startof our program...");
		System.out.println("Stufffff.....");

		try {
			Thread.sleep(1000);
			// throw new InterruptedException(); // we can throw exceptions ourselves
			// throw new OutOfMemoryError();     // we can also throw errors (but why?)
			// System.exit(0);					 // this will halt the app, nothing past this line will be executed
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			// will almost always be executed
			System.out.println("This is in the finally block!");
		}

		System.out.println("This is after the try/catch/finally blocks.");

		// Order of catch blocks matters! catch exceptions starting with the most specific.
		// try {
		//	throwSomething();
		// } catch (InterruptedIOException e) {
		//	e.printStackTrace();
		// }  // GET REST OF BLOCK LATER

		Bicycle myBike = new Bicycle();
		System.out.println("gear: " + myBike.gear + " " + myBike.speed);

		myBike.speedUp(24);
		System.out.println("gear: " + myBike.gear + " " + myBike.speed);

		myBike.speedUp(2);
		System.out.println("gear: " + myBike.gear + " " + myBike.speed);

		try {
			myBike.slowDown(26);
		} catch (NegativeSpeedException nse) {
			myBike.speed = 0;
			nse.printStackTrace();
		}
		System.out.println("gear: " + myBike.gear + " " + myBike.speed);
	}

	// include a throws clause on a method's signature to force any calling method to handle it.
	// Also known as propagating
	public static void throwSomething() throws InterruptedIOException {
		System.out.println("This method might throw an exception");
	}
}