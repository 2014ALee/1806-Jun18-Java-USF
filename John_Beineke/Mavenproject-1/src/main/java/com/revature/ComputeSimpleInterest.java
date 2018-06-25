package com.revature;

import java.util.Scanner;

public class ComputeSimpleInterest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the principal: ");
		double principal = input.nextDouble();
		
		System.out.println("Please enter the rate of interest: ");
		double rateOfInterest = input.nextDouble();
		
		System.out.println("Please enter the number of years: ");
		double numYears = input.nextDouble();
		
		System.out.printf("%.2d", computeSimpleInterest(principal, rateOfInterest, numYears));
		
	}
	
	public static double computeSimpleInterest(double principal, double rateOfInterest, double numYears) {
		double interest;
		interest = principal*rateOfInterest*numYears;
		return interest;
	}

}
