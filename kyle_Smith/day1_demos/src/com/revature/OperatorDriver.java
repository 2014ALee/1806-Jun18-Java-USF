package com.revature;

public class OperatorDriver {

	public static void main(String[] args) {
		
		/*
		 * Operators
		 * 
		 * Types:
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
		 *  	Postfix and Prefix
		 */
		
		//prefix logical NOT
		boolean bool = true;
		System.out.println("not bool = " + !bool);
		
		//prefix positive
		int x = +456;
		System.out.println(x);
		
		//prefix increment
		System.out.println(++x);
		
		//binary numbers
		int myBinary = 0b0010;
		//octal numbers
		int myOctal = 010;
		//hex numbers
		int myHex = 0x3f;

		/*
		 * Assignment Operators
		 */
		//simple assignemnt
		int z = 54;
		
		//plus-equals
		z+=5;
		
		//and-equals
		boolean k = true;
		
		
	
	}
}


