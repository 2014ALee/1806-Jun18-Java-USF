package com.revature;

import static com.revature.models.MyStaticClassMembers.*;		// imports only static field and methods
//import com.revature.models.MyStaticClassMembers.*;		// import every non-static member

public class StaticDriver {

	public static void main (String[] args) {
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		
		System.out.println("Increment count: " + incrementNumber(count));
	}
}
