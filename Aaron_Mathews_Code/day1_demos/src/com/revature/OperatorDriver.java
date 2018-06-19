package com.revature;

public class OperatorDriver {

	public static void main(String[] args) {
		/*
		 * Operators
		 * 
		 * Types: - Unary - Arithmetic - Relational - Logical - Assignment - Bitwise
		 * Shifting - Ternary
		 */

		/*
		 * Unary Operators
		 * 
		 * - Postfix and Prefix
		 */

		// Prefix Logical NOT

		boolean bool = true;
		System.out.println("not bool " + !bool);

		// prefix positive
		int x = +456;
		System.out.println(x);

		// prefix negative
		int y = 456;
		System.out.println(-y);

		// prefix increment
		System.out.println(++x);

		// prefix decrement
		System.out.println(--x);

		/*
		 * Arithmetic
		 * 
		 * Addition Subtraction Multiplication Division Modulus
		 */

		// Addition
		int mySum = 4 + 5;

		// Subtraction
		int myDiff = mySum - 7;

		// Multiplication
		int myProduct = mySum * myDiff;

		// Division
		double myQuotient = myDiff / mySum;
		System.out.println(myQuotient); // Doesn't work properly

		myQuotient = (double) myDiff / mySum;
		System.out.println(myQuotient);

		// Modulus

		double myRemainder = 12 % 5;
		System.out.println(myRemainder);

		/*
		 * Relational
		 * 
		 */
		int a = 0;
		int b = 1;
		int c = 2;

		System.out.println(a > b);

		/*
		 * Logical
		 */

		// logical AND
		boolean one = true;
		boolean two = false;
		boolean three = true;
		System.out.println(one && two);
		System.out.println(one && three);

		// logical OR
		System.out.println(one || two);
		
		/*
		 * Bitwise (Short circuit) Operators
		 */
		
		//bitwise AND
		//If first value is false, it exits as false and doesn't look at the second value
		System.out.println(two & one);
		
		//bitwise OR
		
		//bitwise XOR
		System.out.println(one ^ three);
		
		//Binary (Base 2)
		int myBinary = 0b0010;
		
		//Octal (
		int myOctal = 010;
		
		//Hexadecimal (Base 16)
		int myHex = 0x3f;
		
		/*
		 * Assignment Operators
		 */
		
		//Simple assignment
		int z = 54;
		
		//Plus equals
		z += 5;
		
		//Minus equals
		z -= 10;
		
		//Mult. Equals
		z *= 4;
		
		//Divide equals 
		z /= 2;
		
		//Mod equals
		z %= 2;
		
		//AND equals
		boolean u = true;
		u &= true;
		
		/*
		 * Order of Operations
		 * 
		 * postfix
		 * prefix
		 * multiplicative (Multiplication, Division, Modulus)
		 * Additive (Addition, subtraction)
		 * Shifting
		 * Relational
		 * Equality
		 * Bitwise AND
		 * Bitwise XOR
		 * Bitwise OR
		 * Logical AND
		 * Logical OR
		 * Ternary
		 * Assignment
		 */
	}
}
