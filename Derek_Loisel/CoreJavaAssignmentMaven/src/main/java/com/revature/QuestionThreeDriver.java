package com.revature;

public class QuestionThreeDriver {
	
	//Q3. Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	
	public static void main(String[] args) 
	{
		//method to reverse a string without using temp vars or StringBuilder/StringBuffer
		reverseString("reverse this string");		
	}
	
	private static void reverseString(String str)
	{	
		//go through each char of the string as a char array
		for(char letter : str.toCharArray())
		{
			//tack the chars onto the front of the string one at a time
			str = letter + str;
		}
		
		//only keep the first half of the string which contains the chars you tacked on
		str = str.substring(0, str.length()/2);
		//print out the remaining reversed string
		System.out.println(str);
	}
}
