package com.revature;

import java.util.ArrayList;
import java.util.List;

public class OperatorDriver {

	public static void main(String[] args) {
		/*
		 * Operators
		 * 
		 * Types:
		 *   - Unary
		 *   - Arithmetic
		 *   - Relational
		 *   - Logical
		 *   - Assignment
		 *   - Bitwise Shifting
		 *   - Ternary
		 */
		
		/*
		 * Unary Operators
		 * 
		 * 		Postfix and Prefix
		 */
		
		// Prefix logical NOT
		boolean bool = true;
		System.out.println("not bool = " + !bool);
		
		// Prefix positive
		int x = +456;
		System.out.println(x);
		
		// Prefix negative
		int y = 78;
		System.out.println(-y);
		
		// Prefix increment
		System.out.println(++x);
		
		// Prefix decrement
		System.out.println(--x);
		
		// Postfix increment
		System.out.println(x++);
		
		// Postfix decrement
		System.out.println(x--);
		System.out.println(x);
		
		/* 
		 * Arithmetic Operators
		 * 
		 * Addition
		 * Subtraction
		 * Multiplication
		 * Division
		 * Modulus
		 */
		//addition
		int mySum = 4 + 5;
		System.out.println(mySum);
		
		// subtraction
		int myDifference = mySum - 7;
		System.out.println(myDifference);
		
		// multiplication
		int myProduct = mySum * myDifference;
		System.out.println(myProduct);
		
		// division
		double myQuotient = myDifference / mySum;
		System.out.println(myQuotient); // This doesn't work probably b/c int division
		
		myQuotient = 2/9;
		System.out.println(myQuotient);
		
		myQuotient = 2d / 9; // or both, would have to (double) vars
		System.out.println(myQuotient);
		
		myQuotient = (double) myDifference / mySum;
		System.out.println(myQuotient);
		
		int myValue = 0;
		long myLongValue = 3453453453L;
		myValue = (int) myLongValue;
		System.out.println(myValue); // What happens when too big to be an int? wrong number
		
		int myRemainder = 12 % 5;
		System.out.println(myRemainder);
		
		/*
		 * Relational Operators
		 */
		
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 2;
		String myStr = "hello";
		
		ArrayList<String> myArrayList = new ArrayList<>();
		
		System.out.println(a > b);
		System.out.println(a<b);
		System.out.println(c < d);
		System.out.println(c <= d);
		System.out.println(d >= a);
		System.out.println(c == d);
		System.out.println(a != b);
		System.out.println(myStr instanceof String); // Class
		System.out.println(myStr instanceof Object); // Superclass
		System.out.println(myArrayList instanceof List); // Interface; all true
		
		/*
		 * Logical Operators
		 */
		boolean value1 = true;
		boolean value2 = false;
		boolean value3 = true;
		boolean result;
		
		// logical AND (looks at both)
		result = value1 && value2;
		System.out.println(result);
		
		result = value1 && value3;
		System.out.println(result);
		
		// logical OR (no XOR, have to invoke wrapper class)
		result = value1 || value2;
		System.out.println(result);
		
		/*
		 * Bitwise Operators (Short-Circuit Operators)
		 */
		// bitwise AND (only looks at v1, if v1 is false)
		result = value2 & value1;
		System.out.println(result);
		
		// bitwise OR (only looks at v1, if v1 is true) 
		result = value1 | value2;
		System.out.println(result);
		
		// bitwise XOR
		result = value1 ^ value3;
		System.out.println(result);
		
		int myBinary = 0b0010;
		int myOctal = 010;
		int myHex = 0x3f;
		
		System.out.println("Binary (2): " + myBinary + "\nOctal (8): " + myOctal + "\nHexadecimal (16) " + myHex);
		
		/*
		 * Assignment Operators
		 */
		// simple assignment
		int z = 54;
		
		// plus-equal
		z += 5;
		
		// minus-equals
		z -= 10;
		
		// multiply-equals
		z *= 4;
		
		// divide equals
		z /= 2;
		
		// mod equals
		z %= 6;
		
		// And-equals (bitwise)
		boolean k = true;
		k &= true;
		
	}
}
