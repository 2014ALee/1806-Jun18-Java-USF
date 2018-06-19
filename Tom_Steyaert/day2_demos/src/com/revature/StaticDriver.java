package com.revature;

import static com.revature.models.MyStaticClassMembers.*;

public class StaticDriver {

	public static void main(String[] args) {
		
		//using a static import we no longer need to type "myStaticClassMembers.INCREMENT"
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		
		//it also shortens the invocation of the static method 'incrementNumber()'
		System.out.println("Incremement count: " + incrementNumber(count));
		
		
		
	}
	
}
