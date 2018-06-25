package com.revature;

import com.revature.model.ImplementInterface;

public class InterfaceDriver {
	
	public static void main(String[] args) {
		ImplementInterface inter = new ImplementInterface();
		int i = 10;
		int x = 5;
		
		System.out.println("10 + 5 = " + inter.addition(i, x));
		System.out.println("10 - 5 = " + inter.subtraction(i, x));
		System.out.println("10 * 5 = " + inter.multiplication(i, x));
		System.out.println("10 / 5 = " + inter.division(i, x));

	}

	
}
