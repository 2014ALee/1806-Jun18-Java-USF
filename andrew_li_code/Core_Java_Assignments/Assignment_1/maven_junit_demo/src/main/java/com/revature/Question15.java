package com.revature;

// We stored the class in another package since
// I want this current package to only contain
// the questions.
import com.revature.utility.question.fifteen.Implementor;
import com.revature.utility.question.fifteen.OurInterface;

public class Question15 {
	private static OurInterface implementingClass = null;
	/*
	 * We can use this as the class with main method,
	 * asked of question 15.
	 */
	public static void main(String[] args) {
		if (implementingClass == null) {
			implementingClass = Implementor.getImplementor();
		}
		else {
			return;
		}
		/*
		 * Hardcoding of two operands and calling the implementing
		 * methods...
		 */
		System.out.println("implementingClass.addition(904.230, 123.293): " 
				+ addition(904.230, 123.293));
		System.out.println("implementingClass.subtraction(904.230, 123.293): " 
				+ subtraction(904.230, 123.293));
		System.out.println("implementingClass.multiplication(904.230, 123.293): " 
				+ multiplication(904.230, 123.293));
		System.out.println("implementingClass.division(904.230, 123.293): " 
				+ division(904.230, 123.293));
	}
	public static double addition(double b, double a) {
		return implementingClass.addition(b, a);
	}
	public static double subtraction(double b, double a) {
		return implementingClass.subtraction(b, a);
	}
	public static double multiplication(double b, double a) {
		return implementingClass.multiplication(b, a);
	}
	public static double division(double b, double a) {
		return implementingClass.division(b, a);
	}
}