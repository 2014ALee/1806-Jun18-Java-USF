package com.revature;

import java.util.Arrays;

public class PrintEvenNumber {

	public static void evenNumber() {

		int size = 100;
		int[] number = new int[size];

		// Add element in number array list
		for(int i = 0; i < 100; i++) {
			number[i] = i+1;
			//System.out.println(number[i]);
		}
		
		System.out.println("The array content:");

		System.out.println(Arrays.toString(number));
		
		//print even number in 100
		
		System.out.println("The even numbers are:");

		for(int i : number) {
			if((i %2) == 0) {
				System.out.print(" "+i);
			}
		}
	}
}
