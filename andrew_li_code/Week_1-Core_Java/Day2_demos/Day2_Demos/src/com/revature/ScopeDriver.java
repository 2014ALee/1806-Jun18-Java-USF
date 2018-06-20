package com.revature;

public class ScopeDriver {
	
	public static int x = 0;
	
	public static void main(String[] args) {
		System.out.println(x);
		System.out.println(changeX(x));
		System.out.println(x);
	}
	
	public static int changeX(int x) {
		return ++ScopeDriver.x;
	}
	
}
