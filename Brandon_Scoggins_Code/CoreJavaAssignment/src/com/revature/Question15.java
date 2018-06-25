package com.revature;
// design an interface with abstract methods for addition, subtraction, multiplication, and division
// inherit the interface and implement the methods
// call the implemented methods from a seperate class with a main method
import com.revature.models.Question15Interface;

public class Question15 implements Question15Interface {

	@Override
	public void addition(double a, double b) {
		System.out.println(a + " + " + b + " = " + (a + b));
	}

	@Override
	public void subtraction(double a, double b) {
		System.out.println(a + " - " + b + " = " + (a - b));
	}

	@Override
	public void multiplication(double a, double b) {
		System.out.println(a + " * " + b + " = " + (a * b));
	}

	@Override
	public void division(double a, double b) {
		System.out.println(a + " / " + b + " = " + (a / b));
	}
}
