package com.revature;

// The concrete and abstract class are placed in another package.
import com.revature.utility.question.eighteen.OurConcreteClass;

public class Question18 {
	/*
	 * Question 18 asks us to have a class with
	 * main method to test the concrete class,
	 * this could be our testing class.
	 */
	public static void main(String[] args) {
		OurConcreteClass oCC = new OurConcreteClass();
		String testString1 = "Hello World!!";
		String testString2 = "revature";
		String testString3 = "Math";
		String testString4 = "12042";
		/*
		 * Formatting the results.
		 */
		System.out.println("The statement that \""
				+ testString1 + "\" has upper case letters is "
				+ oCC.hasUpperCase(testString1));
		System.out.println("The statement that \""
				+ testString2 + "\" has upper case letters is "
				+ oCC.hasUpperCase(testString2));
		System.out.println(testString3
				+ " converted to upper case is "
				+ oCC.makeUpperCase(testString3));
		System.out.println(oCC.printAddByTen(testString4));
	}
}
