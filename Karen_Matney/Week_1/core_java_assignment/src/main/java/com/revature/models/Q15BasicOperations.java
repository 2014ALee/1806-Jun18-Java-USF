/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q15BasicOperations.java
 * Code for Q15 of Core Java Assignment. Class that implements the interface Q15BasicMath for question Q15.
 */
package com.revature.models;

public class Q15BasicOperations implements Q15BasicMath {
	@Override
	public double addition(double a, double b) {
		return a + b;
	}

	@Override
	public double subtraction(double a, double b) {
		return a - b;
	}

	@Override
	public double multiplication(double a, double b) {
		return a * b;
	}

	@Override
	public double division(double a, double b) {
		return a / b;
	}
}
