package com.revature;
// use a loop to print a triangle-ish shape of 1's and 0's
public class Question13 {

	public static void main(String[] args) {

		int countLines = 1;
		int prints = 0;
		
		for (int i = 0; i < 10; i++) {
			System.out.print((i % 2) + " ");
			prints++;
			if (prints == countLines) {
				prints = 0;
				countLines++;
				System.out.println();
			}	
		}
	}
}
