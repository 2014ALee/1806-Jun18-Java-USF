package com.revature;
// find the minimum of 2 numbers using ternary operators
public class Question10 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 6;
	
		int minValue = (num1 < num2) ? num1 : num2;
		
		System.out.println("The smaller value between '" + num1 + "' and '" + num2 +"' is: " + minValue);
	}
	
	// is it true/false or more like if(true)/else ?
}
