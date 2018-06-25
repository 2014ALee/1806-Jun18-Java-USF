/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q15TestOperations.java
 * Code for Q15 of Core Java Assignment. Tests the Q15MathOperations implementation
 * of Q15BasicMath.
 */
package com.revature;

import com.revature.models.Q15BasicOperations;

public class Q15TestOperations {
	public static void main(String[] args) {
		double a = 50.0;
		double b = 33.3;

		Q15BasicOperations bo = new Q15BasicOperations();

		System.out.println("a = " + a + "; b = " + b);
		System.out.println("Addition: " + bo.addition(a, b));
		System.out.println("Subtraction: " + bo.subtraction(a, b));
		System.out.println("Multiplication: " + bo.multiplication(a,b));
		System.out.println("Division: " + bo.division(a, b));
	}
}
