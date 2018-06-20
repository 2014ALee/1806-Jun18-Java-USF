package com.revature;

// static imports import ONLY the static members of the targeted class
import static com.revature.models.MyStaticClassMembers.*;
// this allows us to bring in anything, fields or methods

public class StaticDriver {
	
	public void main(String[] args) {
		// using a static import we no longer have to type 'MyStaticClassMembers.INCREMENT
		System.out.println("Increment Value: " + INCREMENT);
		
		int count = 10;
		
		System.out.println("Increment Count: " + incrementNumber(count));
	}

}
