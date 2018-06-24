package com.revature;

public class QuestionSixDriver {

public static void main(String[] args) {
	
	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	
	//this method returns a string telling you whether 5 is odd or even
	String oddOrEven = oddOrEvenInt(5);	
	
	//print the string
	System.out.println(oddOrEven);
}

	public static String oddOrEvenInt(int i) {
		
		String str = "";
		
		//divide int by 2
		int num = i/2; 

		//now multiply the int by 2.  If it was divisible by 2 there would be no rounding and it will equal i.
		//if it wasn't divisible by 2 it would have been rounded because it's an int, so it won't equal i.
		if(num * 2== i){ 
			str = "even"; 
		}else {
			str = "odd";
		}
		
		return str;
	}
}
