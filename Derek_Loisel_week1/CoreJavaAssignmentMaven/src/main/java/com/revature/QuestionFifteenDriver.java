package com.revature;

import com.revature.models.QuestionFifteen;

public class QuestionFifteenDriver {

	/*Q15. Write a program that defines an interface having the following methods: addition, subtraction, multiplication, and division.  
	Create a class that implements this interface and provides appropriate functionality to carry out the required operations. 
	Hard code two operands in a test class having a main method that calls the implementing class.*/
	
	public static void main(String[] args) {
		
		double numOne = 6;
		double numTwo = 3;
		
		//methods from class that implements interface
		QuestionFifteen qf = new QuestionFifteen();
		double additionSolution = qf.addition(numOne, numTwo);
		double subtractionSolution = qf.subtraction(numOne, numTwo);
		double multiplicationSolution = qf.multiplication(numOne, numTwo);
		double divisionSolution = qf.division(numOne, numTwo);	
		
		//print the answers that the methods returned
		System.out.println(additionSolution);
		System.out.println(subtractionSolution);
		System.out.println(multiplicationSolution);
		System.out.println(divisionSolution);
	}
	
}

