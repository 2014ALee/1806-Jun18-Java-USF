package answers;

import java.util.Scanner;

public class Question17 {
	// Calculating simple interest

	public static void main(String[] args) {
		// Initialize the scanner
		Scanner scan = new Scanner(System.in);
		
		// Get the required info. If there is a problem,
		// it's almost certainly due to invalid input. If
		// an exception occurs, just restart the program.
		try {
			System.out.print("Enter the principal: ");
			double principal = scan.nextDouble();
			
			System.out.print("Enter the interest rate: ");
			double rate = scan.nextDouble();
			
			System.out.print("Enter the time in years: ");
			double time = scan.nextDouble();
			
			// Doing the math here
			double interest = calculateSimpleInterest(principal, rate, time);
			System.out.println("The simple interest is $" + interest);
		}
		catch(Exception e) {
			System.out.println("Invalid Input!");
			main(args);
		}
	}
	
	public static double calculateSimpleInterest(double principal, double rate, double time) {
		return principal * rate * time;
	}

}
