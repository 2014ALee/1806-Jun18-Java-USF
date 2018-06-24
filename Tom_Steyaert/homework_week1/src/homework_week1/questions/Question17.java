package homework_week1.questions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Question17 {

	static Scanner inputReader = new Scanner(System.in);	
	private static int principal;
	private static double rate;
	private static int time;

	//we get user input to get our loan information, one field at a time
	//if the user inputs the wrong data type needed, we throw an exception
	//and tell them an incorrect input was entered
	public static double calculateInterest() throws InputMismatchException {

		System.out.println("Provide your loan's principal, rate, and duration below");

		System.out.print("Principal: ");
		principal = inputReader.nextInt();

		System.out.print("Rate (as a decimal): ");
		rate = inputReader.nextDouble();

		System.out.print("Duration (in years): ");
		time = inputReader.nextInt();	

		double interest = principal*rate*time;

		System.out.println("The simple interest on your loan is " + interest);

		return interest;
	}


	public static void main(String[] args) {

		try {
			calculateInterest();
		} catch (InputMismatchException e) {
			System.out.println("Incorrect type entered...");
			inputReader.nextLine();
			calculateInterest();
		}

	}

}
