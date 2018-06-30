/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q18StringManipulationDriver.java
 * Code for Q18 of Core Java Assignment. A driver class for testing the
 * string manipulation methods in Q18
 */
package com.revature;

import com.revature.models.Q18StringManipulation;;

public class Q18StringManipulationDriver {
	public static void main(String[] args) {
		String test = "ao ijejaf;kjIKawjf";
		boolean isUpper;
		Q18StringManipulation sm = new Q18StringManipulation();
		
		// any Uppercase tests
		System.out.println("Original String: " + test);
		isUpper = sm.anyUppercase(test);
		System.out.println("Is uppercase?: " + isUpper);
		
		test = "ajfoijea fdjoiwef";
		
		System.out.println("String: " + test);
		isUpper = sm.anyUppercase(test);
		System.out.println("Is uppercase?: " + isUpper);
		
		// All caps test
		test = "aoijejaf;kjI Kawjf";
		System.out.println("Original String: " + test);
		test = sm.allUppercase(test);
		System.out.println("Final String (All Caps): " + test);
		
		// Conversion plus ten test
		test = "234";
		System.out.print("Number string: " + test + "\nPlus 10: ");
		sm.convertAddten(test);
	}
}
