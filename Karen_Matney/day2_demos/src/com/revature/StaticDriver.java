package com.revature;

import static com.revature.models.MyStaticClassMembers.*; // Access modifiers still apply

public class StaticDriver {
	
	public static void main(String[] args) {
		// using a static import we no longer have to type "MyStaticClassMembers.INCREMENT"
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		
		// it also shortens the invocation of the static method 'incrementNumber()'
		System.out.println("Increment count: " + incrementNumber(count));
	}

}
