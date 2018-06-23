package com.revature;

public class QuestionSixDriver {

public static void main(String[] args) {
	
	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	
	//this method tells you whether 5 is odd or even
	oddOrEvenInt(5);	
	//this method tells you whether 20 is odd or even
	oddOrEvenInt(20);
}

	private static void oddOrEvenInt(int i) {
		
		//divide int by 2
		int num = i/2; 

		//now multiply the int by 2.  If it was divisible by 2 there would be no rounding and it will equal i.
		//if it wasn't divisible by 2 it would have been rounded because it's an int, so it won't equal i.
		if(num * 2== i){ 
			System.out.println("int i is EVEN"); 
		}else {
			System.out.println("int i is ODD");
		}
	}
}
