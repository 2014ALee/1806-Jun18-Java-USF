package com.revature;

import com.revature.models.MathImp;

public class MathDriver {
	public static void main(String[] args) {
		MathImp maths = new MathImp();
		int i = 20;
		int j = 5;
		System.out.println(maths.add(i, j));
		System.out.println(maths.subtract(i, j));
		System.out.println(maths.multiply(i, j));
		System.out.println(maths.division(i, j));
	}
	
}
