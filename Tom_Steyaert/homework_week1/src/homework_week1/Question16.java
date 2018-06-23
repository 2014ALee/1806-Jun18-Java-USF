package homework_week1;

import java.util.Scanner;

public class Question16 {
static Scanner inputReader = new Scanner(System.in);
	
	
	public static int numberOfChars(String[] args) {
		String ourString = args[0];
		
		int numberOfChars = ourString.length();
		
		System.out.println("Characters in the String inputed: " + numberOfChars);
		
		return numberOfChars;
	}
	
	public static void main(String[] args) {
		String[] argsToPass = new String[1];
		
		System.out.print("Enter a String: ");

		String str = inputReader.nextLine();

		argsToPass[0] = str;

		numberOfChars(argsToPass);
	}
	
}
