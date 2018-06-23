package com.revature;

public class QuestionFiveDriver {

//	Q5. Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
//	Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
	
	
	
	public static void main(String[] args) {
		
		//prints the subString "Hello"
		System.out.println(subString("Hello There", 5));
	}
	
	public static String subString(String str, int idx) {
		
		String subStr = "";
		
		//loop as many times as the passed idx to go through that much of the string
		for (int i = 0; i < idx; i++) {
			
			//add the index of the str Char Array to the end of the subStr
			subStr += str.toCharArray()[i];
		}
		
		return subStr;
	}
}
