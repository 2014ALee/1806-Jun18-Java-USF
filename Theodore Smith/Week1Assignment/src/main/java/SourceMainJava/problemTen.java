package SourceMainJava;

import java.util.Scanner;

public class problemTen {

	public static void main(String[] args) {
		
		int num;
		int num2;
		int result;
		
		
		// We use scanner here because we are using a user input. The nextInt which is used in a lot of my programs so far read the integer that the user create.
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the First Number: ");
		
		num = scanner.nextInt();
		
		System.out.println("Enter the Second Number: ");;
		
		num2 =scanner.nextInt();
		
		scanner.close();
		
		// checking to see which number is smallest and display that information.
		
		result = num < num2 ? num : num2;
		
		System.out.println("  The smallest number is: " + result);
		
	}

}
