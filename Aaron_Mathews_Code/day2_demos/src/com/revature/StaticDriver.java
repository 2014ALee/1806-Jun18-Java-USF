package com.revature;


//static import
//imports only static members
import static com.revature.models.MyStaticClassMembers.*;
//Static import eliminates need to type "MyStaticClassMembers.INCREMENT"

public class StaticDriver {
	
	public static void main(String[] args) {
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		
		System.out.println("Increment count: " + incrementNumber(count));
		
	}

}
