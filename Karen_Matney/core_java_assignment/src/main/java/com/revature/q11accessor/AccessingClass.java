/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * AccessingClass.java
 * Code for Q11 of Core Java Assignment. Class holding two floats for a class outside of this package to access.
 */
package com.revature.q11accessor;

import com.revature.q11.HoldingClass;

public class AccessingClass extends HoldingClass {
	public static void main(String[] args) {
		System.out.println("This is a public float from another class in another package: ");
		System.out.println(f1);
		System.out.println("This is a protected float from another class in another package: ");
		System.out.println(f2);
		
		System.out.println("\nNow changing the previous variables");
		f1 = 2340.2384f;
		f2 = 30.1234f;
		
		System.out.println("This is a public float from another class in another package: ");
		System.out.println(f1);
		System.out.println("This is a protected float from another class in another package: ");
		System.out.println(f2);
	}
}