package com.revature;

// Static imports import ONLY the static members of the targeted class
import static com.revature.models.MyStaticClassMembers.*; // Access modifiers still apply

// We still will need to import the class itself if we intend to instantiate an object of that type
import com.revature.models.MyStaticClassMembers;

public class StaticDriver {
	public static void main(String[] args) {
		// using a static import we no longer have to type "MyStaticClassMembers.INCREMENT"
		System.out.println("Increment value: " + INCREMENT);

		int count = 10;

		// it also shortens the invocation of the static method 'incrementNumber()'
		System.out.println("Increment count: " + incrementNumber(count));
	}
}