package com.revature;

public class QuestionSixteen {

	
//	Q16. Write a program to display the number of characters for a string input. 
//	The string should be entered as a command line argument using (String [ ] args).
	
	public static void main(String[] args) {
	
		//get the string passed as a command line argument
		String argsString = getArgsString(args);
		//print the string
		System.out.println(argsString.length());
		
		//Short solution:
		//System.out.println(args[0].length());
	}
	
	public static String getArgsString(String[] argsArray) {
		
		return argsArray[0];
	}
	
	
}
