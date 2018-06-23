package com.revature;

public class ReverseString {
	
	public void reverseString() {
		
		String myString = "Hello World";
		char myReverseString;
		
		System.out.println("The reverse of Hello World is:");
		
		for(int i = myString.length() -1; i >= 0; i--) {
			
			//Store the characters of myString in reverse order
			myReverseString = myString.charAt(i);
			System.out.print(myReverseString);
		}
	}

}
