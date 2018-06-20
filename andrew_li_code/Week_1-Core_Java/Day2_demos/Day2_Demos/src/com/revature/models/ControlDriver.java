package com.revature.models;

public class ControlDriver {
	
	public static void main(String[] args) {
		/*
		 * There are five types of decision making statements:
		 * 	- if statement
		 * 	- if/else statement
		 * 	- if/else-if statements
		 * 	- nested if statements
		 * 	- switch statements
		 */
		
		/*
		 * if
		 * 
		 * An if statement consists of a condition, followed by a statement or set of statements.
		 * 
		 * The statements within the if block are only executed if the condition is found to be true.
		 * Otherwise, the statements are ignored completely.
		 * 
		 */
		int num = 72;
		
		if (num < 100) {
			System.out.println("The variable \"num\" is less than 100");
		}
		else {
			System.out.println("The variable \"num\" is greater than or equal to 100");
		}
		
		String str = "Haiiiiii";
		switch (str) {
			case "Greetings":
				System.out.println("Greetings to you!");
				break;
			case "Haiiiiii":
				System.out.println("Haiii cutie!!!");
				break;
			case "Goodbye":
				System.out.println("Goodbye for now!");
				break;
			default:
				System.out.println("Default!");
		}
		
		/*
		 * Looping statements
		 * 
		 * Loops are used to execute a set of statements repeatedy until a particular condition is met. In Java, we have three basic looping structures.
		 * - for, while, and do-while
		 * 
		 * 
		 */
		for (int i = 0; i < 5; i++) {
			System.out.println("The value of \"i\" is: " + i);
		}
		
		int number = 0;
		while (number < 10) {
			System.out.println("Number " + number);
			number++;
		}
		
		
		
	}
	
}
