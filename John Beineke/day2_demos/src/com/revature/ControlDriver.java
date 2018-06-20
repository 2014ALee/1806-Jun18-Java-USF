package com.revature;

/*
 * Flow Control refers to the practice of managing the way that our application executes
 *  by using special statement types. these statements include:
 * 
 * 
 */
public class ControlDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of decision making statements:
		 * 		-if statements
		 * 		-if/else statements
		 * 		-if/else/if statements
		 * 		-nested if statements
		 * 		-switch statements 
		 */
		
		/*
		 * if
		 * 
		 * An if statement consists of a condition, followed by a statement 
		 * or set of statements
		 * 
		 */
		int num = 72;
		
		if(num< 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		}
		
		/*
		 * Switch Statement
		 * 
		 * byte, short, char, int
		 * 
		 * Character, Byte, Short, Integer, String
		 */
		
		String str = "Greeting";
		
		switch(str) {
		case "greeting":
			System.out.println("Hello There!");
			break;
		case "goodbye":
			System.out.println("Goodby for now.");
			break;
		case "Greeting":
			System.out.println("CAasing is important!");
			break;
		case "Goodbye":
			System.out.println("Goodby for now.");
			break;
		default:
			System.out.println("Nothing matched..");
			
		// Without break statements, we experience fall through (The contents of all 
		// cases will executed)
			
		/*
		 * Looping statements
		 * 
		 * Loops are used to execute a set of statements repeatedly until 
		 * a particular condition is met. In Java, we have a for, while, do while
		 */
			
		/*
		 * For loop consists of the 'for' keyword, followed by a set of parentheses that
		 * contain:
		 * 	-Initialization step
		 * 	-Conditional step
		 * 	-Manipulative or Iterative step
		 * 
		 * Can define multiple variables in the initialization step
		 */
			
			
		/*
		 * Do while
		 * 
		 */
			
		int number = 0;
		do {
			System.out.println("This will execute atleast once!");
		} while (number <0);
			
			
			
			
		}
	}

}









