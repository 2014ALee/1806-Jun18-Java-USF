package com.revature;

import static com.revature.models.MyStaticClassMembers.*;

public class StaticDrive {
	public static void main(String[] args) {
		//using a static import you don't need to type the preceding class name
		System.out.println("Increment values: " + INCREMENT);
		
		int count = 10;
		
		System.out.println("Increment count: " + incrementNumber(count));
	}

}
