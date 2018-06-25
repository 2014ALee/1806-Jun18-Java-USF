/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q16StringCharCounter.java
 * Code for Q16 of Core Java Assignment. For a string in the command line arguments, prints out the number of characters.
 */
package com.revature;

public class Q16StringCharCounter {
	public static void main(String[] args) {
		int numArgs = args.length;
		if(numArgs == 0) {
			System.out.print("No arguments entered in the command line");
		} else if(numArgs == 1) {
			System.out.print(args[0].length());
		} else {
			System.out.print("Too many arguments entered in the command line");
		}
	}
}
