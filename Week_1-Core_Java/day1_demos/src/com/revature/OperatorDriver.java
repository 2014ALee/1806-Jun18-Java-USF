package com.revature;

public class OperatorDriver {

	public static void main(String[] args) {
	
		/*
		 * Operators
		 * Types
		 * 	-Unary
		 * 	-Arithmetic
		 *  -Relational
		 *  -Logical 
		 *  -Assignment
		 *  -Bitwise Shifting
		 *  -Ternary
		 */
		
		
		/*
		 *Unary
		 *	 
		 *	Postfix and Prefix
		 * 
		 */
		
		// prefix logical not
		
		boolean bool = true;
		System.out.println(!bool);
		
		//prefix negative
		int x = +456;
		System.out.println(-x);
		
		//prefix increment 
		System.out.println(++x);
		
		//prefix decrement
		System.out.println(--x);
		
		//postfix increment 
		System.out.println(x++);
		
		//postfix decerement
		System.out.println(x--);
		
		double myQuotient=2.0/9;
		System.out.println(myQuotient);
		
		double myRemainder = 12%5;
		System.out.println(myRemainder);
		
		
		
		int a = 0;
		
		String myStr = "hello";
		System.out.println(myStr instanceof String);
		
		
		//bitwise operator
		//shortcircuit, if one is false then doesn't even continue loookoing
		// single &
		
		//bitwise XOR represented by ^
		
		
		int myBinary = 0b00101; //base 2
		int myOcatal = 010; //base 8
		int myHex = 0x3f; //base 16
		
		int z=4;  //simple
		z+=5;//plus equals
		z-=10; //minus equals
			
		// AND-equals
				boolean k = true;
				k &= false;
//				k=k&true;	same as above	
				System.out.println(k);
	
		
		
		
		
		
	}
	
	
}
