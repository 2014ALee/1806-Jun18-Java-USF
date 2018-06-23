package com.revature;

import java.util.Scanner;

public class IntrestCalc {
	static double principal;
	static double rate;
	static int years;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter principal: ");
		principal = scanner.nextDouble();
		 
		System.out.print("Enter rate: ");
		rate = scanner.nextDouble();
		
		System.out.print("Enter year: ");
		years = scanner.nextInt();
		
		System.out.println(intrestCalc(principal, rate, years));
		scanner.close();
	}
	
	public static double intrestCalc(double principal, double rate, int years) {
		double intrest = principal * rate * years;
		return intrest;
	}
}
