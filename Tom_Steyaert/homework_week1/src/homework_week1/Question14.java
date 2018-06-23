package homework_week1;

import java.util.*;

public class Question14 {

	static Scanner inputReader = new Scanner(System.in);
	static Date date = new Date();

	public static int getCaseNumber(){
		int userInput = 0;


		System.out.println("Choose an option");
		System.out.println("Option 1: Find the square root of a number using the Math class method");
		System.out.println("Option 2: Display today’s date");
		System.out.println("Option 3: Split the following string and store it in a string array. \"I am learning Core Java\"\n");	
		System.out.print("Option:");

		try {

			userInput = inputReader.nextInt();

		} catch(Exception e) {

			System.out.println("Invalid input, try again\n");
			System.out.println("-------------------------------------------------------------------");
			inputReader.nextLine();
			goToCases();
		}
		return userInput;
	}

	public static void goToCases() {

		int userInput = getCaseNumber();

		System.out.println("user input is: " + userInput + "\n");


		switch(userInput) {

		case 1 :
			System.out.println("Enter number to get square root of: ");

			userInput = inputReader.nextInt();

			System.out.println("The square root is " + Math.sqrt(userInput) + "\n");
			break;

		case 2 :

			System.out.println("The date is "+ date.toString().substring(0, 9));
			break;

		case 3 :

			String str = "I am learning Core Java";
			String[] stringArray = str.split("learning");
			break;

		default :

			System.out.println("Invalid input, try again\n");
			System.out.println("-------------------------------------------------------------------");
			inputReader.nextLine();
			goToCases();
		}		
	}

	public static void main(String[] args) {
		goToCases();	
	}
}
