package com.revature;

//static import so you dont need to list the class name to use the static member
import static com.revature.models.MyStaticClassMembers.*;

public class StaticDriver {

	public static void main(String[] args) {
		System.out.println("Increment value: " + INCREMENT); //dont need to say MyStaticClassMembers.INCREMENT to get the variable because of the static import
	
		int count = 10;
		
		System.out.println("Increment count: " + incrementNumber(count)); //works for methods too
	}
}
