package com.revature;
import java.util.Scanner;

public class TernaryCompare {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the first number you would like to compare.");
		int num1 = input.nextInt();
		System.out.println("Enter the second number you would like to compare.");
		int num2 = input.nextInt();
		
		System.out.println(findMin(num1, num2));

	}
	
	private static int findMin(int n1, int n2) {
		int min = (n1 < n2) ? (min = n1) : (min = n2);
		return min;
	}

}
