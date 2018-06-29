package com.revature;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases: 
//	Case 1: Find the square root of a number using the Math class method.
//	Case 2: Display today’s date.
//	Case 3: Split the following string and store it in a string array.
//	           	“I am learning Core Java”


public class QuestionFourteenDriver {

	public static void main(String[] args) {
		//pring the getString() method
		System.out.println(getSwitchString(2));
		
	}

	public static String getSwitchString(int i) {
		switch(i) {
		case 1:
			//return the sqrt of the passed number
			String sqrt = Double.toString(Math.sqrt(49));
			return sqrt;
		case 2:
			//return todays date
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			return dateFormat.format(date);
		case 3:
			String str = "I am learning Core Java";
			//split the string at each space and store in string array
			String[] splitStrings = str.split(" ");
			//print the array
			System.out.println(Arrays.toString(splitStrings));
			//just return the original string
			return str;
		default:
			return "default";
		}
	}
}