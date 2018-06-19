package com.revature;

import java.util.ArrayList;
import java.util.List;


public class OperatorDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Operators
		 * 
		 * Types:
		 * 	- Unary
		 * 	- Arithmetic
		 * 	- Relational
		 * 	- Logical
		 * 	- Assignment
		 * 	- Bitwise Shifting
		 * 	- Ternary
		 */
		
		/*
		 * Unary Operators
		 * 
		 * 		Postfix and Prefix
		 */
		
		// prefix logical NOT
		boolean bool = true;
		System.out.println("not bool = " + !bool);
		
		// prefix positive
		int x = +456;
		System.out.println(x);
		
		// prefix negative
		int y = 78;
		System.out.println(-y);
		
		// prefix increment
		System.out.println(++x);
		
		// prefix decrement
		System.out.println(--x);
		
		// postfix increment
		System.out.println(y++);
		
		//postfix decrement
		System.out.println(y--);
		System.out.println(y);
		
		/*
		 * Arithmetic Operators
		 * 
		 * Addition
		 * Subtraction
		 * Multiplication
		 * Division
		 * Modulus
		 */
		// addition
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
		System.out.println(myQuotient); // this doesn't work properly...
		
		myQuotient = 2 / 9;
		System.out.println(myQuotient); // this doesn't work
		
		myQuotient = 2d / 9d;
		System.out.println(myQuotient);
		
		myQuotient = 2. / 9.;
		System.out.println(myQuotient);
		
		myQuotient = 2. / 9;
		System.out.println(myQuotient);
		
		myQuotient = (double) myDifference / mySum;
		System.out.println(myQuotient);
		
		int myValue = 0;
		long myLongValue = 345345348768734345L;
		myValue = (int) myLongValue;
		System.out.println(myValue);
		
		double myRemainder = 12 % 5;
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
		System.out.println(a < b);
		System.out.println(c < d);
		System.out.println(c <= d);
		System.out.println(d >= a);
		System.out.println("------------");
		System.out.println(myStr instanceof String);
		System.out.println(myStr instanceof Object);
		System.out.println(myArrayList instanceof ArrayList);
		System.out.println(myArrayList instanceof List);
		System.out.println("------------");
		System.out.println(c == d);
		System.out.println(a != b);
		System.out.println("------------");
		
		java.awt.List myAwtList; 	// I can still access non-imported classes using the fully-qualified path name
		
		/*
		 * Logical Operators
		 */
		boolean value1 = true;
		boolean value2 = false;
		boolean value3 = true;
		
		// logical AND
		boolean result = value1 && value2;
		System.out.println(result);
		
		result = value1 && value3;
		System.out.println(result);
		
		// logical OR
		result = value1 || value2;
		System.out.println(result);
		
		/*
		 * Bitwise Operators (Short-Circuit Operators)
		 */
		// bitwise AND
		result = value2 & value1;
		System.out.println(result);
		
		// bitwise OR
		result = value1 | value2;
		System.out.println(result);
		
		// bitwise XOR
		result = value1 ^ value3;
		System.out.println(result);
		
		int myBinary = 0b0010; //base 2
		int myOctal = 010; // base 8
		int myHex = 0x3f; // base 16
		
		System.out.println(myBinary);
		System.out.println(myOctal);
		System.out.println(myHex);
		
		/*
		 * Assignment Operators
		 */
		// simple assignment
		int z = 54;
		
		// plus-equals
		z += 5;
		System.out.println(z);
		
		// minus-equals
		z -= 10;
		System.out.println(z);
		
		// multiply-equals
		z *= 4;
		System.out.println(z);
		
		// divide-equals
		z /= 2;
		System.out.println(z);
		
		// mod-equals
		z %= 6;
		System.out.println(z);
		
		
	}

}
