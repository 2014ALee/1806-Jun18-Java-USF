package com.revature;

import java.util.Scanner;

public class Q17 { 
	public static void main(String[] args)
	{
		//gets input
		Scanner input = new Scanner(System.in);
		//three floats for the three parts of the simple interest function
		float Principal;
		float numOfYears;
		float rateOfInterest;
		
		System.out.println("Calculate your intrest!");
		System.out.print("Enter your principal value: ");
		Principal = input.nextInt();
		System.out.print("Enter your interest rate: ");
		rateOfInterest = input.nextFloat();
		System.out.print("Enter how long your interest has been compounded(in years): ");
		numOfYears = input.nextFloat();
		System.out.println("Your interest is... $"+interestCalculator(Principal, numOfYears, rateOfInterest)+"! Have fun paying it.");
		
		input.close();
	}
	public static float interestCalculator(float Principal, float numOfYears, float rateOfInterest)
	{
		float theInterest;
		
		theInterest = (Principal*numOfYears*rateOfInterest);
		
		return theInterest;
	}

}
