package homework_week1.questions;

import java.util.*;

public class Question14 {

	static Scanner inputReader = new Scanner(System.in);
	static Date date = new Date();

	public static void goToCases(int caseNumber) {

		switch(caseNumber) {

		case 1 :
			System.out.println("Enter number to get square root of: ");

			int userInput = inputReader.nextInt();

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

			System.out.println("Invalid input");
		}		
	}

	public static void main(String[] args) {
	
	
	}
}
