/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q17SiimpleInterest.java
 * Code for Q17 of Core Java Assignment. Calculates simple interest based on user input through a Scanner object.
 */
package com.revature;

import java.util.Scanner;

public class Q17SimpleInterest {
	double principle;
	double rate;
	double time;
	
	Q17SimpleInterest() { }
	
	// Creates an object with the values set.
	Q17SimpleInterest(double principle, double rate, double time) {
		this.principle = principle;
		this.rate = rate;
		this.time = time;
	}
	
	// Calculates interest
	public double calcInterest(){
		double interest = principle * rate * time;
		return interest;
	}
	
	public static void main(String[] arguments) {
		double principle = 0.0;
		double rate = 0.0;
		double time = 0.0;
		Scanner sysIn = new Scanner(System.in);
		Q17SimpleInterest simpleInterest;
		
		// Collecting user input
		System.out.print("Enter the principle: ");
		if(sysIn.hasNextDouble()) {
			principle = sysIn.nextDouble();
		} else {
			System.out.println("Invalid value");
		}
		
		System.out.print("Enter the rate: ");
		if(sysIn.hasNextDouble()) {
			rate = sysIn.nextDouble();
		} else {
			System.out.println("Invalid value");
		}
		
		System.out.print("Enter the time: ");
		if(sysIn.hasNextDouble()) {
			time = sysIn.nextDouble();
		} else {
			System.out.println("Invalid value");
		}
		
		sysIn.close();
		
		// Initializing an object of Q17SimpleInterest
		simpleInterest = new Q17SimpleInterest(principle,rate,time);
		
		// Performing the calculation
		System.out.println("Interest: " + simpleInterest.calcInterest());
	}
}
