package com.revature;

import java.util.Scanner;

public class Q10 { 
	public static void main(String[] args) {
		//initializes the scanner to read input
		Scanner input = new Scanner(System.in);
		//the two numbers to be inputted, and the int that holds the minimum
		int num1;
		int num2;
		//strings for the input
		String number1 = new String();
		String number2 = new String();
		
		
		System.out.println("Enter two numbers:");
		System.out.print("Number 1: ");
		number1 = input.nextLine();
		num1 = Integer.parseInt(number1);
		System.out.print("Number 2: ");
		number2 = input.nextLine();
		num2 = Integer.parseInt(number2);
		System.out.println(minFinder(num1,num2) + " is the minimum.");
		input.close();
	}
	public static int minFinder(int num1, int num2)
	{
		int min;

		//uses a ternary instead of an if statement to find the minimum. if num1 is greater than num2, min is set equal to num2's value and is
		//outputted as such.
		min = (num1 > num2) ? num2 : num1;
		
		return min;
		
	}

}
