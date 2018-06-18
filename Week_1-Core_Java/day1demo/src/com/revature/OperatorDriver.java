package com.revature;

public class OperatorDriver {
	
	public static void main(String[] args) {
		/*
		 * Operators
		 * There's the normal math ones (plus, minus, multiply, divide, modulus)
		 * Relational
		 * Unary
		 * Logical (and, or)
		 * Assignment
		 * Bitwise Shifting
		 * Ternary
		 * Assignment
		 * Shifting
		 */
		
		/*
		 * Unary Operators
		 * Postfix and Prefix
		 */
		//prefix logical NOT
		boolean bool = true;
		System.out.println("not bool = " + !bool);
		//prefix positive
		int x = +456;
		System.out.println(x);
		
		//prefix negative
		int y = 76;
		System.out.println(-y);
		
		//prefix increment
		System.out.println(++x);
		
		//prefix decrement
		System.out.println(--y);
		
		//postfix increment
		System.out.println(x++);
		
		//postfix decrement
		System.out.println(y--);
		
		/*Arithmetic Operators
		 * (+ - *) are all obvious.
		 * Make sure you use Doubles for the division 
		 * int division is bad
		 * if you have a variable that needs to be divided, cast one of them.
		 */
		//casting
		int mySum = 4 + 3;
		int myDifference = 5-1;
		
		double myQuotient =  (double)mySum/ myDifference;
		System.out.println(myQuotient);
		
		/*
		 * Relational Operators
		 * Compares numbers. Always a boolean value. (<, >, =, <=, >=, ==, !=)
		 */
		//Instanceof
		String myStr = "hello";
		System.out.println(myStr instanceof String);
		
		
		// Logical Operators

		boolean value1 = true;
		boolean value2 = false;
		boolean value3 = true;
		
		//logical AND
		boolean result = value1 && value2;
		System.out.println(result);
		
		//logical OR
		result = value3 || value2;
		System.out.println(result);
		
		
		/*
		 * Bitwise Operators (Short-Circuit Operators)
		 */
		//bitwise AND
		result = value2 & value1;
		System.out.println(result);
		
		//bitwise OR
		result = value3 | value2;
		System.out.println(result);
		
		//bitwise XOR (exclusive or. Only in bitwise, checks if two things are not the same.)
		result = value1 ^ value3;
		System.out.println(result);
		
		/*
		 * Assignment Operators
		 * Sets a variable to a value. Always contains an =.
		 */
		int z;
		//simple assignment
		z = 12;
		//plus equals
		z += 12;
		//minus equals
		z -= 12;
		//multiply equals
		z *= 12;
		//divide equals
		z /= 12;
		//modulus equals
		z %= 12;
		//and-equals
		z &= 12;
		
		int myBinary = 0b0010; //base 2
		int myHex = 0x3f; //base 16
		int myOctal = 010; //base 8

	}

}
