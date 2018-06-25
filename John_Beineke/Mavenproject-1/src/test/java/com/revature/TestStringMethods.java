package com.revature;

import java.util.Scanner;

public class TestStringMethods extends StringMethodsImpl {

	public static void main(String[] args) {
		
		StringMethodsImpl tester = new StringMethodsImpl();

		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a string: ");
		String str = input.nextLine();	
		System.out.println(tester.checkUpperCase(str));
		
		System.out.println("\nEnter a string to convert it to upper case: ");
		String str2 = input.nextLine();
		System.out.println(tester.lowerCaseToUpperCase(str2));
		
		System.out.println("\nEnter a number: ");
		String str3 = input.nextLine();
		int result = tester.stringToInt(str3);
		System.out.println(result);

	}

}
