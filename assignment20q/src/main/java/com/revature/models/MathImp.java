package com.revature.models;

public class MathImp implements MathFace {

	@Override
	public void add(int i, int k) {
		// TODO Auto-generated method stub
		System.out.println(i + k);
	}

	@Override
	public void subtract(int i, int k) {
		// TODO Auto-generated method stub
		System.out.println(i - k);
	}

	@Override
	public void multiply(int i, int k) {
		// TODO Auto-generated method stub
		System.out.println(i * k);
	}

	@Override
	public void division(int d, int g) {
		// TODO Auto-generated method stub
		if (d != 0 & g != 0)
			System.out.println(d/g);
	}

}
