package com.revature;

import com.revature.models.MathImp;

public class MathDriver {
	public static void main(String[] args) {
		MathImp maths = new MathImp();
		int i = 20;
		int j = 5;
		maths.add(i, j);
		maths.subtract(i, j);
		maths.multiply(i, j);
		maths.division(i, j);
	}
	
}
