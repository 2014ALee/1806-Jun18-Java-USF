package com.revature;

//static imports import ONLY the static members of the targeted class
import static com.revature.models.MyStaticClassMembers.*;

public class StaticDriver {
	
	public static void main(String[] args) {
		//using a static import we no longer have to type "MyStaticClassMembers.ICREMENT"
		System.out.println("Increment value: " + INCREMENT);
		
		int count = 10;
		
		//it also shortens the invocation of the static method 'incrementNumber()'
		System.out.println("Increment count: " + incrementNumber(count));
	}
}
