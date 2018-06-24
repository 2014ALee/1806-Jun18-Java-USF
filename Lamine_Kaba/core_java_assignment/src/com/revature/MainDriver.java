package com.revature;

import java.io.IOException;

import com.floatvariable.FloatVariableClass;

public class MainDriver {

	public static void main(String[] args) {
		
		/*
		 * Q1  Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		 */
		// Original array
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		// Instantiate BubbleSortArray object
		
		BubbleSortArray mySortedArray = new BubbleSortArray();
		
		// Call sorting Method on the object
		
		mySortedArray.bubbleSortArray(array);
		
		// Print the sorted values
		for(int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]);
			System.out.print(" ,");
		}
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q2  Write a program to display the first 25 Fibonacci numbers beginning at 0.
		 */
		
		FibonacciNumbers myFibonacci = new FibonacciNumbers();
		
		myFibonacci.display();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q3  Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

		 */
		
		ReverseString myReverse = new ReverseString();
		
		myReverse.reverseString();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q4  Write a program to compute N factorial.
		 */
		
		Nfactorial.factorial();	
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q5 Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 
		 */
		
		SubstringMethod mySubstring = new SubstringMethod();
		
		mySubstring.substringMethod("Lamine", 4);
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q6 Write a program to determine if an integer is even without using the modulus operator (%)

		 */
			
		EvenInteger.evenInteger();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q7  Sort two employees based on their name, department, and age using the Comparator interface.
		 */
		
		/*
		 * Q8 Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
			“karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,  “refer”, “billy”, “did”

		 */
		
		Palindrome.palindrome();
		
		System.out.println("\n-------------------------------");
		
		/*
		 * Q9  Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		 */
		
		NumberArrayList .numberArrayList();
		
		/*
		 * Q10  Find the minimum of two numbers using ternary operators.
		 */
		
		System.out.println("\n-------------------------------");
		
		TernaryOperator.ternaryOperator();
		
		/*
		 * Q11  Write a program that would access two float-variables from a class that exists in another package. Note, you will need to create two packages to demonstrate the solution.
		 */
		
		System.out.println("\n-------------------------------");
		
		FloatVariableClass myFloat = new FloatVariableClass();
		
		myFloat.myCheckingBalance = 3.4f;
		myFloat.mySavingsBalance = 59.33f;
		
		myFloat.getVariables();
		
		/*
		 * Q12 Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		 */
		
		System.out.println("\n-------------------------------");
		
		PrintEvenNumber.evenNumber();
		
		/*
		 * Q13 Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.

		 */
		
		System.out.println("\n-------------------------------");
		
		Triangle.triangle();
		
		/*
		 * Q14  Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
			Case 1: Find the square root of a number using the Math class method.
			Case 2: Display today’s date.
			Case 3: Split the following string and store it in a string array.
               “I am learning Core Java”
		 */
		
		SwitchCase.switchCase();
		
		/*
		 * Q15  Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  Create a class that implements this interface and provides appropriate functionality to carry out the required operations. Hard code two operands in a test class having a main method that calls the implementing class.
		 */
		
		System.out.println("\n-------------------------------");
		
		InterfaceMathMethos calculate = new InterfaceMathMethos();
		
		int i = 4; int j = 5;
		
		System.out.println(i +" + " + j +" is: " +calculate.add(i, j));
		System.out.println(i +" - " + j +" is: " +calculate.subtract(i, j));
		System.out.println(i +" * " + j +" is: " +calculate.mytiply(i, j));
		System.out.println(i +" / " + j +" is: " +calculate.divide(i, j));
		
		/*
		 * Q16 Write a program to display the number of characters for a string input. The string should be entered as a command line argument using (String [ ] args).
		 	This code is in other main() method
		 */
		
		/*
		 * Q17 Write a program that calculates the simple interest on the principal, rate of interest and number of years provided by the user. Enter principal, rate and time through the console using the Scanner class.
			Interest = Principal* Rate* Time
		 */
		
		System.out.println("\n-------------------------------");
		
		InterestCalculator.intCalculator();
		
		/*
		 * Q19 Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
		 */
		
		System.out.println("\n-------------------------------");
		
		ArrayListQ19.question19();
		
		/*
		 * Q20 Create a notepad file called Data.txt and enter the following:
			Mickey:Mouse:35:Arizona
			Hulk:Hogan:50:Virginia
			Roger:Rabbit:22:California
			Wonder:Woman:18:Montana
 
			Write a program that would read from the file and print it out to the screen in the following format:
 
			Name: Mickey Mouse
			Age: 35 years
			State: Arizona State
		 */
		
		System.out.println("\n-------------------------------");
		
		try {
			Datatxt.datatxt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}







































