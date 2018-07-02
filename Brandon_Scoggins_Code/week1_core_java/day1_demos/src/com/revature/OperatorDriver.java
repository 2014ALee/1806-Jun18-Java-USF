package com.revature;

public class OperatorDriver {

	public static void main(String[] args) {
		
		/*
		 * Operators
		 * 
		 * Types
		 *  - Unary
		 *  - Arithmetic
		 *  - Relational
		 *  - Logical
		 *  - Assignment
		 *  - Bitwise Shifting
		 *  - Ternary
		 */
		
		/*
		 * Unary Operators
		 * 
		 * 		Postfix and Prefix
		 */
		
		// prefix logical NOT
		boolean bool = true;
		System.out.println("not bool (where bool = true) = " + !bool);
		
		// prefix positive
		int x = +456;
		System.out.println(x);
		
		// prefix negative
		int y = 12;
		System.out.println(-y);
		
		// prefix increment
		System.out.println(++x);
		
		// prefix decrement
		System.out.println(--y);
		
		// postfix increment
		System.out.println(x++);
		
		// postfix decrement
		System.out.println(y--);
		
		/*
		 * Arithmetic Operators
		 * 
		 * Addition
		 * Subtraction
		 * Mulitplication
		 * Division
		 * Modulus
		 */
		
		//addition
		int mySum = 4 + 5;
		System.out.println(mySum);
		
		//subtraction
		int myDifference = 4 - 5;
		System.out.println(myDifference);
		
		// multiplication
		int myMultiplication = mySum * myDifference;
		System.out.println(myMultiplication);
		
		// division
		double myQuotient = (double) myDifference / mySum;		// cast int's to double for decimal division
		System.out.println(myQuotient);
		
		myQuotient = 2d / 9d;		// use literal 'd' to "cast" int's as double
		System.out.println(myQuotient);
		
		// modulus
		double myRemainder = 12%5;
		System.out.println(myRemainder);
		
		/*
		 * Relational Operators
		 */
		
		int a = 0, b = 1, c = 2, d = 2;
		String myStr = "Hello";
		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(c < d);
		System.out.println(c <= d);
		System.out.println(d >= a);
		System.out.println("--------");
		System.out.println(myStr instanceof String);
		System.out.println(myStr instanceof Object);
		System.out.println("--------");
		System.out.println(c == d);
		System.out.println(c != d);
		
		/*
		 * Logical Operators
		 */
		System.out.println("-----------");
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
		
		System.out.println("----------");
		
		/*
		 * Bitwise Operator
		 */
		
		// bitwise AND (will not check second value if first value is false) (short circuit operator)
		result = value1 & value2;
		System.out.println(result);
		
		// bitwise OR
		result = value1 | value2;
		System.out.println(result);
		
		// bitwise XOR
		result = value1 ^ value2;
		System.out.println(result);
		
		int myBinary = 0b0010; // base 2
		int myOctal = 010;		// base 8
		int myHexidecimal = 0x3f; 	// base 16
		
		System.out.println(myBinary);
		System.out.println(myOctal);
		System.out.println(myHexidecimal);
		
		/*
		 * Assignment Operators
		 */
		
		// simple assignment
		int z = 54;
		 
		// plus-equal
		z += 5;
		
		// minus-equal
		z -= 10;
		
		// muliply-equal
		z *= 4;
		
		// divide-equal
		z /= 2;
		
		// mod-equal
		z %= 3;
		
		// AND-equals
		boolean k = true;
		k &= true;
		
	}
}
