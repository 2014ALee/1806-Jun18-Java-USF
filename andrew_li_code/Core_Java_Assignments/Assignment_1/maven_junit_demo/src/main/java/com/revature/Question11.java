package com.revature;

// Importing from another Package
/*
 * This is how we use variables (such as floats) from
 * a class that exist from another object.
 */
import com.revature.other.OtherClass;

public class Question11 {
	public static void main(String[] args) {
		// To grab the floats from other class.
		float f1 = OtherClass.FLOAT_1;
		float f2 = OtherClass.FLOAT_2;
		
		// Doing stuff with these floats.
		System.out.println("f1 value: " + f1);
		System.out.println("f2 value: " + f2);
		System.out.println("f1 + f2 value: " + (f1 + f2));
		System.out.println("f1 - f2 value: " + (f1 - f2));
		System.out.println("f1 - f2 value: " + (f1 * f2));
		System.out.println("f1 / f2 value: " + (f1 / f2));
	}
}
