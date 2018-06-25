package com.revature;

import com.revature.models.QuestionEighteen;

public class QuestionEighteenDriver extends QuestionEighteen {

	public static void main(String[] args) {

		//create string to pass to methods
		String str1 = "hi";
		String str2 = "5";
		
		//create object to call methods
		QuestionEighteenDriver qed = new QuestionEighteenDriver();
		
		//print if string has an upper case character or not, true/false
		System.out.println(qed.hasUpperCase(str1));
		
		//print the passed string after its changed to all uppercase
		System.out.println(qed.convertToUpper(str1));
		
		//call method that converts the string to int and adds 10 then prints it out from inside the method
		qed.printStringToIntPlusTen(str2);
		
	}

	@Override
	public boolean hasUpperCase(String str){

		char[] ca = str.toCharArray();

		for(char c : ca)
		{
			if (Character.isUpperCase(c)) {
				return true;
			};
		}

		return false;
	}

	@Override
	public String convertToUpper(String str) {

		str = str.toUpperCase();
		
		return str;
	}

	@Override
	public int printStringToIntPlusTen(String str) {

		int i = Integer.parseInt(str);
		i += 10;
		
		//print i because question 18 says to print it from the method
		System.out.println(i);
		
		return i;
	}
}
