package com.revature;

/*
 * Flow control - the practice of managing the the way that our application executes by using special statment types. 
 * These statment types include:
 * 
 * - Decision Making Statements
 * - Looping
 * - Branching Statements
 */

public class ControlDriver {
	
	public static void main(String[] args) {
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of DMS:
		 * 		if
		 * 		if/else
		 * 		if/else-if
		 * 		nested if
		 * 		switch
		 * 
		 * if
		 * - Consists of condition followed by statement or set of statements
		 * - Statments are only executed if the condition is true.
		 * - Otherwise they are ignored
		 */
		
		int num = 72;
		
		if (num < 100) {
			System.out.println(num + ": The variable 'num' is less than 100.");
		}
		
		/*
		 * if/else
		 * 
		 * - Syntactically, begins the same as if statement.
		 * - An additional else block is added to the end.
		 * - Does not have a condition. It is the alternative.
		 */
		
		num = 101;
		
		if (num < 100) {
			System.out.println(num + ": The variable 'num' is less than 100.");
		} else {
			System.out.println(num + ": The variable 'num' is more than 100.");
		}
		
		/*
		 * if/else if
		 * 
		 * - Multiple conditions to be checked
		 * - Exits when a condition is met.
		 */
		
		num = 100;
		
		if (num > 100) {
			System.out.println(num + ": The variable 'num' is more than 100.");
		} else if (num < 100){
			System.out.println(num + ": The variable 'num' is less than 100.");
		} else {
			System.out.println(num + ": The variable 'num' is equal to 100.");
		}
		
		/*
		 * Nested if statements
		 * - if statement inside if statement
		 */
		
		num = 64;
		
		if (num < 100) {
			System.out.println("The variable 'num' is less than 100");
			if (num % 2 == 0) {
				System.out.println("The variable 'num' is even");
			}
		}
		
		/*
		 * Switch Statements (switch keyword)
		 * 
		 * - Work with byte, short, char, int
		 * Character, Byte, Short, Integer, String
		 */
		
		String str = "GREETING";
		switch(str) {
		case "greeting":
			System.out.println("Hello there, fellow coder!");
			break;
		case "goodbye":
			System.out.println("Goodbye for now!");
			break;
		case "Greeting":
			System.out.println("Casing is important, huh?");
			break;
			default:
				System.out.println("Nothing matched...");
		}
		
		
		/*
		 * Looping
		 * 
		 * - for, while, and do-while
		 */
		
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
		}
		
		for (int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			System.out.println("i = " + i + ", j = " + j);
		}
		
		for (int i = 0; i < 100; i += 3) {
			if (i == 0) {
				System.out.print(i);
			} else {
				System.out.println(", " + i);
			}
		}
		
		//Infinite loop
		
//		for (;;) {
//			System.out.println("hi");
//		}
		
//		num = 10;
//		while (num > 1) {
//			System.out.println(num);
//			num--;
//		}
		
		do {
			System.out.println("This will execute at least once");
		} while (num < 10 );
	}

}
