package com.revature;

import static com.revature.models.MyStaticClassMembers.*;

public class StaticDriver {

	public static void main(String[] args) {
		System.out.println("Increment value: " + INCREMENT);
		int count = 10;
		System.out.println("Increment count: " + incrementNumber(count));
	}
	
}
