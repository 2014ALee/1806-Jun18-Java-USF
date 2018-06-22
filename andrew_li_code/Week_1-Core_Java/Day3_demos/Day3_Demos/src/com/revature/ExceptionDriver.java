package com.revature;

import java.io.IOException;
import com.revature.exceptions.*;
import com.revature.models.Bicycle;

public class ExceptionDriver {
	public static void main(String[] args) {
		System.out.println("This is the start of our program...");
		System.out.println("Executing code......");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			System.out.println("This is in the finally block!");
		}
		System.out.println("This is after the try/catch/finally blocks.");
		try {
			throwsDeclared();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bicycle bike = new Bicycle(-120, 1);
		bike.speedUp(24);
		System.out.println(bike);
		bike.speedUp(10);
		System.out.println(bike);
		try {
			bike.slowDown(100);
		} catch (NegativeSpeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(bike);
		
		
	}
	
	public static void throwsDeclared() throws IOException {
		System.out.println("This doesn't really throw any exception");
	}
}
