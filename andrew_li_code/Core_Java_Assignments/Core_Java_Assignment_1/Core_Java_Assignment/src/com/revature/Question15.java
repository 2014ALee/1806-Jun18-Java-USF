package com.revature;

// We stored the class in another package since
// I want this current package to only contain
// the questions.
import com.revature.utility.question.fifteen.Implementor;

public class Question15 {
	/*
	 * We can use this as the test class asked of question
	 * 15.
	 */
	public static void main(String[] args) {
		Implementor implementingClass = new Implementor();
		/*
		 * Hardcoding of two operands and calling the implementing
		 * methods...
		 */
		System.out.println("implementingClass.addition(904.230, 123.293): " 
				+ implementingClass.addition(904.230, 123.293));
		System.out.println("implementingClass.subtraction(904.230, 123.293): " 
				+ implementingClass.subtraction(904.230, 123.293));
		System.out.println("implementingClass.multiplication(904.230, 123.293): " 
				+ implementingClass.multiplication(904.230, 123.293));
		System.out.println("implementingClass.division(904.230, 123.293): " 
				+ implementingClass.division(904.230, 123.293));
	}
}
