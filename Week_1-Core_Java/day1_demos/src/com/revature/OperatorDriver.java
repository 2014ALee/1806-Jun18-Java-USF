package com.revature;

import java.util.ArrayList;
import java.util.List;

public class OperatorDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Operators
		 * 
		 * Types:
		 * - Unary
		 * - Arithmetic
		 * - Relational
		 * - Logical
		 * - Assignment
		 * - Bitwise Shifting
		 * - Ternary
		 * 
		 */
		
		String myStr = "hello";
		
		System.out.println(myStr instanceof String);
		System.out.println(myStr instanceof Object);
	
		ArrayList<String> myArrayList = new ArrayList<String>();
		
		System.out.println(myArrayList instanceof ArrayList);
		System.out.println(myArrayList instanceof Object);
		System.out.println(myArrayList instanceof List);
		
		/* Order of operators
		 *  1 Post fix
		 *  2 Prefix
		 *  3 Multiplication
		 *  4 Additive
		 *  5 Shifting
		 *  6Relational
		 *  7 equality
		 *  8 Bitwise AND
		 *  9 Bitwise Or
		 *  10 Bitwise XOR
		 *  11 Bitwise AND
		 *  12 Logical Or
		 *  13 Ternary
		 *  14 Assignment
		 */

	}

}
