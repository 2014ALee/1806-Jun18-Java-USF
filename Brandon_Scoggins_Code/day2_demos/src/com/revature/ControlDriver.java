package com.revature;

/*
 * Flow Control refers to the practice of managing the way that our application executes by using 
 * special statement types. These statement types include:
 * 
 * 		-Decision Making Statements
 * 		-Looping Statements
 * 		-Branching Statements
 */

public class ControlDriver {

	public static void main (String[] args) {
		
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of decision making statements:
		 * 		-if statements
		 * 		-if/else statements
		 * 		-if/else-if statements
		 * 		-nested if statements
		 * 		-switch statements
		 */
		
		/*
		 * if
		 * 
		 * An if statement consists of a condition, followed by a statement or set of statements.
		 * 
		 * The statements within the if block are only executed if the condition is found to be true.
		 * Otherwise the statements are ignored completely. 
		 */
		
		int num = 72;
		
		if(num < 100)
			System.out.println("The variable 'num' is less than 100");
		
		/*
		 * if/else
		 * 
		 * Syntatically the beginning of an if/else statement is identical to an if statement. However, 
		 * an addition else block (no condition here!) is appended to the end of the if block.
		 * 
		 * If the condition evaluates to true, then the statements within the if block are executed and 
		 * the statements within the else block are ignored. otherwise, the converse happens.
		 */
		
		num = 101;
		
		if (num < 100)
			System.out.println(num + ", The variable \"num\" is less than 100.");
		else
			System.out.println(num + ", The variable \"num\" is greater than or equal to 100.");
		
		/*
		 * if/else-if
		 * 
		 * An if-else-if statement is used when we have multiple conditions that we swish to evaluate for. In
		 * this statement we have only one "if" block and only one "else" block but we can have as many "else-if"
		 * blocks as we swish. This is known as a "if-else-ladder"
		 */
		
		num = 100;
		
		if (num < 100)
			System.out.println(num + ", The variable \"num\" is less than 100.");
		else if(num > 100)
			System.out.println(num + ", The variable \"num\" is greater than 100.");
		else
			System.out.println(num + ", The variable \"num\" is equal to 100.");
		
		/*
		 * Nested if
		 * 
		 * When there is an if statement encapsulated within another if statement, this is referred to as a nested if statement.
		 * 
		 * The code within the outer if statement will only execute if its conditional is found to be true. Otherwise, the code inside
		 * will be ignored. The code within our nested if is executed only if both the outer if conditional and its own condition both
		 * evaluate to true.
		 */
		
		num = 98;
		
		if (num < 100 && num % 2 == 0) {
			System.out.println(num + ", The variable \"num\" is less than 100.");
//			if (num % 2 == 0)
				System.out.println(num + ", The variable \"num\" is even.");
		}
		
		/*
		 * Switch
		 * 
		 * works with byte, short, int, char
		 * 
		 * Byte, Short, Character, Integer, String
		 */
		
		String str = "Greeting";
		
		switch(str) {
		case "greeting":
			System.out.println("Hello there, fellow coder!");
			break;		// without break statements, we get fall through!
		case "goodbye":
			System.out.println("Goodbye for now!");
			break;
		case "Greeting":
			System.out.println("Casing is important, huh?");
			break;
		default:
			System.out.println("Nothing matched...");
		}
		
		// doesnt work with relational operators
//		switch(num) {
//		case num > 100:
//		}
		
		/*
		 * Looping
		 * 
		 * Loops are used to execute a set of statements repeatedly until a particular condition is met.
		 * In Java, we have three basic looping structures:
		 * 
		 * 		- for
		 * 		- while
		 * 		- do-while
		 */
		
		/*
		 * for
		 * 
		 * A for loop consists of the 'for' keyword, followed by a set of parenthesis that contain:
		 * 		- initialization step 
		 * 		- condition step
		 * 		- manipulation step (iterative step)
		 */
		
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		System.out.println("--------------------------------");
		
		for(int i = 10; i > 3; i--) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		System.out.println("--------------------------------");
		
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
//			System.out.println("The value of 'i' is: " + i);
//			System.out.println("The value of 'j' is: " + j);
			if(i == 0)
				System.out.print(i);
			else
				System.out.print(", " + i);
		}
		
		//functional code but infinite loop
//		for(;;) {
//			System.out.println("hey");
//		}
		
		System.out.println("\n--------------------------------");
		
		/*
		 * While
		 */
		
		int number = 10;
		while(number > 1) {
			System.out.println(number);
			number -= 1;
		}
		
		/*
		 * do-while
		 */
		
		number = 0;
		
		do {
			System.out.println("This will execute at least once.");
			
		}while(number <0);
		
		
		
			
			
			
			
			
			
			
			
			
			
	}
}
