package com.revature;

//import java.util.Arrays;

public class VarArgsDriver {
	
	//variable arguments - lets you create a function that can accept different/any number of arguments and stores them in an array to use in the function
	
	//ex 3
	
	public static void main(String[] args) {
		
		System.out.println(addAnyAmountOfNumbers(5,10,15,20,25,30));
	}
	
	public static int addAnyAmountOfNumbers(int... numbersToAdd) {
		
		int total = 0;
		
		for(int num : numbersToAdd){
			total += num;
		}
		
		return total;
	}
	
	//ex 1
	/*
	public static void main(String... args) {
		display("hi", new int[] {5, 6, 7});
	}

	public static void display(String strValue, int... values) {
		
			System.out.println(strValue);
			
			for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		}
	}
	*/
	
	//ex 2
	/*
	public static void main(String[] args) {
		display(1,2,3,4,5,6,7);
	}
	
	public static void display(int... values) {
		System.out.println(Arrays.toString(values));
	}
	*/
	
	

	
	
}
