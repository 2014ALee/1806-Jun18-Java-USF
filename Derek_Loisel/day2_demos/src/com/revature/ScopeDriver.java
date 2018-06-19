package com.revature;

public class ScopeDriver {

	public static int x = 0;
	
	public static void main(String[] args) {
		
		System.out.println(x); //prints 0
		System.out.println(changeX(x)); //prints 1
		System.out.println(x); //prints 0 because the value is passed, but x itself isnt changed unless you set x equal to value in the changeX method
	}
	
	public static int changeX(int value) {
		return ++value;
	}
}
