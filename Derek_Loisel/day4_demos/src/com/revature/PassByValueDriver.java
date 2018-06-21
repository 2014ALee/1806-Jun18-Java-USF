package com.revature;

public class PassByValueDriver {

	
	public static void main(String[] args) {
		
		/*
		 * Passing primitives as parameterse
		 * 
		 * In Java, when we pass a variable ofa primitive data type into a method - a copy of the variable is made and manipulated within the method.  
		 * this means that changes made within the method have no effect on the original variable.
		 * 
		 * it might seem like its passed by reference for objects because the variable will change without reassigning it 
		 * but thats because the objects value itself is a reference, java is always passed by value.
		 */
		
		int i = 5;
		System.out.println(i); //prints 5
		incrementValue(i);
		System.out.println(i);//prints 5
		
	}
	
	private static void incrementValue(int i)	{
		i++;
	}
}
