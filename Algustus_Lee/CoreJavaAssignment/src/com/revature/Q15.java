package com.revature;

public class Q15 implements Q15Interface{
	public static void main(String[] args) {
		//Everything here is meant to be used in the Test class that this question required.
		int x = 74;
		int y = 61;
		//these here were meant to demonstrate the ability to call Interfaces
		Q15Interface.multiplication(x, y);
		Q15Interface.addition(x, y);
		Q15Interface.division(x, y);
		Q15Interface.subtraction(x, y);
		
		
	}

}
