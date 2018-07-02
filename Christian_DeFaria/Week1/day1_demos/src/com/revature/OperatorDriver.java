package com.revature;

import java.util.ArrayList;
import java.util.List;

public class OperatorDriver {
	public static void main(String[] args) {
		
		/*
		 * Operators
		 * 
		 * Types:
		 * -Unary
		 * -Arithmetic
		 * -Relational
		 * -Logical
		 * -Assignment
		 * -Bitwise
		 * -Ternary
		 */
		
		/*
		 * Unary Operators
		 * 
		 * 		Postfix and Prefix
		 * 
		 */
		
		// prefix logical NOT
		boolean bool = true;
		System.out.println("not bool = " + !bool);
		
		//prefix positive
		int x = +456;
		System.out.println(x);
		
		//prefix negative
		int y = 78;
		System.out.println(-y);
		
		//prefix increment
		System.out.println(++x);
		
		//prefix decrement
		System.out.println(--x);
		
		//postfix increment
		System.out.println(y++);
		System.out.println(y);
		
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
		//addition
		int mySum = 4+5;
		System.out.println(mySum);
		
		//subtraction
		int myDifference = mySum - 7;
		System.out.println(myDifference);
		
		//multiplication
		int myProduct = mySum * myDifference;
		System.out.println(myProduct);
		
		//division
		double myQuotient = myDifference/mySum;
		System.out.println(myQuotient);
		
		myQuotient = 2/9;					//doesn't work
		System.out.println(myQuotient);
		
		myQuotient = 2d/9d;
		System.out.println(myQuotient);
		
		myQuotient = 2./9.;
		System.out.println(myQuotient);
		
		myQuotient = 2./9;
		System.out.println(myQuotient);
		
		myQuotient = (double) myDifference/mySum;
		System.out.println(myQuotient);
		
		int myValue = 0;
		long myLongValue = 3453453453L;
		myValue = (int) myLongValue;
		System.out.println(myValue);
		
		//modulus
		double myRemainder = 12 % 5;
		System.out.println(myRemainder);
		
		/*
		 * Relational Operators
		 */
		int a = 0;
		int b = 1;
		int c = 2;
		int d = 2;
		String myStr = "Hello";
		
		ArrayList<String> myArrayList = new ArrayList<>();
		
		System.out.println(a>b);
		System.out.println(a<b);
		System.out.println(c<d);
		System.out.println(c<=d);
		System.out.println(d>=a);
		
		System.out.println("----------");
		
		System.out.println(myStr instanceof String);
		System.out.println(myStr instanceof Object);
		System.out.println(myArrayList instanceof List);
		System.out.println(c == d);
		System.out.println(a != b);
		System.out.println("----------");
		
		/*
		 * Logical Operators
		 */
		boolean value1 = true;
		boolean value2 = false;
		boolean value3 = true;
		//logical AND
		System.out.println(value1 && value2);
		System.out.println(value1 && value3);
		//logical OR
		System.out.println(value1 || value2);
		
		/*
		 * Bitwise Operators
		 */
		//bitwise AND
		System.out.println(value2 & value1);
		
		//bitwise OR
		System.out.println(value1 | value2);
		
		//bitwise XOR
		System.out.println(value1 ^ value3);
		
		int myBinary = 0b0010;	//base 2
		int myOctal = 010;		//base 8
		int myHex = 0x3f;		//base 16
		
		System.out.println(myBinary);
		System.out.println(myOctal);
		System.out.println(myHex);
		
		
	}
}
