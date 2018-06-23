package com.revature.models;

public class MathImp implements MathFace {

	@Override
	public int add(int i, int k) {
		// TODO Auto-generated method stub
		return(i + k);
	}

	@Override
	public int subtract(int i, int k) {
		// TODO Auto-generated method stub
		return (i - k);
	}

	@Override
	public int multiply(int i, int k) {
		// TODO Auto-generated method stub
		return(i * k);
	}

	@Override
	public int division(int d, int g) {
		// TODO Auto-generated method stub
		if (d != 0 & g != 0)
			return(d/g);
		return 0;
	}

}
