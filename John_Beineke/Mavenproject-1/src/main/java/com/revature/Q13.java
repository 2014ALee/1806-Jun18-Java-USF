package com.revature;

public class Q13 {

	public static void main(String[] args) {
	
		printToConsole();

	}
	
	public static String printToConsole() {
		// with the help of Lamine
		// Declare rows
		int rows = 4;
		String str = "";
		// create loop for amount of rows
		for (int i = 0; i <= rows; i++) {
			// Create loop to print 0 or 1
			// do while j <= i, so it will print the same amount of numbers as the row it is on
			
			for(int j = 1; j <= i; j++) {
				// if j is even, print 0
				if(j % 2 == 0) {
					str += " 0";
				}
				// else print 1
				else {
					str+=" 1";
				}
			}
			// new line after each row.
			System.out.println();
		}
		return str;
	}

}
