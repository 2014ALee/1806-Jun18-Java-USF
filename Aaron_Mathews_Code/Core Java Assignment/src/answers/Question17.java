package answers;

import java.util.Scanner;

public class Question17 {
	
	public static void main(String[] args) {
		findInterest();
	}
	
	public static void findInterest() {
		double interest;
		double principal;
		double rate;
		double time;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the principal amount (excluding commas): ");
		principal = scan.nextDouble();
		System.out.println("You entered: " + principal);
		
		System.out.print("Enter the interest rate as a decimal: ");
		rate = scan.nextDouble();
		System.out.println("You entered: " + rate);
		
		System.out.print("Enter the amount of time in years: ");
		time = scan.nextDouble();
		System.out.println("You entered: " + time);
		
		interest = principal * rate * time;
		System.out.println("The amount of interest is: " + interest);
	}

}
