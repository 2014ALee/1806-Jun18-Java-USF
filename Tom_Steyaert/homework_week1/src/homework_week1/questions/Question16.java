package homework_week1.questions;

import java.util.Scanner;

public class Question16 {
	static Scanner inputReader = new Scanner(System.in);

	//the user inputs a string and we store it into an array of strings
	public static String[] getStringFromUser() {
		String[] argsToPass = new String[1];

		System.out.print("Enter a String: ");

		String str = inputReader.nextLine();

		argsToPass[0] = str;

		return argsToPass;

	}

	//now we count the number of characters in the first (and only) string in our string array
	public static int numberOfChars(String[] args) {
		String ourString = args[0];

		int numberOfChars = ourString.length();

		System.out.println("Characters in the String inputed: " + numberOfChars);

		return numberOfChars;
	}


	public static void main(String[] args) {
		String[] argsToPass = new String[1];
		argsToPass = getStringFromUser();
		numberOfChars(argsToPass);
	}	
}
