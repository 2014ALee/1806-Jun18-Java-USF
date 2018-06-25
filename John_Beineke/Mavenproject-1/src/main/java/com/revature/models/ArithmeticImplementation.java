package com.revature.models;
public class ArithmeticImplementation implements Arithmetic {

	public static void main(String[] args) {

		
	
	}

	@Override
	public double addition(double num1, double num2) {
		double result = num1 + num2;
		return result;
	}

	@Override
	public double subtraction(double num1, double num2) {
		double result = num1 - num2;
		return result;
	}

	@Override
	public double multiplication(double num1, double num2) {
		double result = num1 * num2;
		return result;
	}

	@Override
	public double division(double num1, double num2) {
		double result = num1 / num2;
		return result;
	}
	
	

}
