package SourceMainJava;

import java.util.Scanner;

public class problemSix {

	public static void main(String[] args) {
		
		System.out.println("Enter a value so we can see if it is even: " );
		
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		
		int answer = (number / 2) * 2;
		
		if (answer == number) {
			System.out.print("Success this is an EVEN number");
		} else {
			System.out.print("Sorry guy this is odd");
		}
		
	}
// Needed this for problem 12
	public static boolean isEven(int numberEven) {
		
		return true;
	}

}
