package com.revature;

//only grabs the static member of MyStaticClassMembers
//does not grab the class
import static com.revature.models.MyStaticClassMembers.*;//* imports only the static values

public class StaticDriver {

	public static void main(String[] args) {
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		 
		System.out.println("Increment count: " + incrementNumber(count));
	}
}
