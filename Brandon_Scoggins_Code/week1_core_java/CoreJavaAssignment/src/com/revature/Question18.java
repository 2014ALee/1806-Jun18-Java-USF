package com.revature;

import com.revature.models.Question18Implementor;

// main method to test the implementation of abstract methods
public class Question18 {

	private static String myString = "wHat It iS";
	
	public static void main(String[] args) {
		
		Question18Implementor q18 = new Question18Implementor();
		
		System.out.println(q18.hasUpperCase(myString));
		
		if(q18.hasUpperCase(myString))
			System.out.println(q18.toUpperCase(myString));
		
		q18.toIntAndAdd(myString);
	}
}
