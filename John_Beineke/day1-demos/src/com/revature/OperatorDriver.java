package com.revature;

public class OperatorDriver {

	public static void main(String[] args) {
		/*
		 * Operators
		 * 
		 * Types:
		 * - Unary
		 * - Arithmetic
		 * - Logical
		 * - Assignment
		 * - Bitwise Shifting
		 * - Ternary
		 */
		
		/*
		 * Unary Operators
		 * 
		 * Postfix and Prefix
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
		
		// prefix decrement (--)
		
		// Postfix increment (x++)
		System.out.println(x++);  		// will print THEN increment
		// Postfix decrement
		
		
		/*
		 * Arithmetic Operators
		 * 
		 * Addition
		 * Subtraction
		 * Multiplication
		 * Division
		 * Modulus
		 */
		
		/*
		 * Relational Operators
		 * 
		 * 
		 */
		
		int a = 0;
		int b = 1;
		int c = 2;
		
		System.out.println(a > b);
		
		boolean value1 = true;
		boolean value2 = false;
		boolean value 3 = true;
		boolean result;
		/*
		 * Bitwise or short-circuit operators
		 */
		// bitwise only looks at first value if false
		
		// bitwise AND
		result = value2 & value2;
		System.out.println(result);
		
		// bitwise or
		result = value1 | value2;
		System.out.println(result);
		
		//bitwise XOR
		result = value1 ^ value3;
		System.out.println(result);
		
		int myBinary = 0b0010;
		int myOct = 010;
		int myhex = 0x3f;
		
		/* order of precedence for operators
		*postfix
		*prefix
		*multiplication, division, modulus (multiplicative)
		*addition, subtraction (additive)
		*SHifting
		*relational
		*equality
		*bitwise AND
		*bitwise XOR 
		*bitwise OR
		*logical AND
		*logical OR
		*/
		
		/*
		 * Assignment operators
		 */
		
		// simple assignment
		int j = 54;
		// plus=
		j += 5;
		// minus=
		j -= 10;
		
	}

}
