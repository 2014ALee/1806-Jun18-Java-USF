package com.revature;

/*
 * Flow control refers to the practice of managing the way that our application executes by using
 * special statement types. These statement types include:
 * 
 * 	- Descision Making Statements
 * 	- Looping Statements
 *	- Branching Statements
 */

public class ControlDriver {
	public static void main(String[] args) {
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of decision making statements:
		 * 	- if statements
		 * 	- if/else statements
		 * 	- if/else-if statements
		 * 	- nested if statements
		 *	- switch statements
		 */
		
		/*
		 * if
		 * 
		 * An if statement consists of a condition, followed by a statement or set of statements.
		 * 
		 * The statements within the block are only executed if the condition is found to be true.
		 * Otherwise, the statements are ignored completely.
		 */
		
		int num = 72; 
		
		if(num < 100) {
			System.out.println(num + ", The variable 'num' is less than 100");
		}
		
		/*
		 * if/else
		 * 
		 * Syntatically the beginning of an if/else statement is identical to an if statement. However,
		 * an additional else block (no conditional here!) is appended to the end of the if block.
		 * 
		 * If the conditional evaluates to true, then the statements within the if block are executed,
		 * and the statements within the else block are ignored. Otherwise, the converse happens.
		 */
		num = 101;
		
		if(num < 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		} else {
			System.out.println(num + ", The variable \"num\" is more than 100");
		}
		
		/*
		 * if/else-if
		 * 
		 * An if-else-if is used when we have multiple conditions that we wish to evaluate for. In
		 * this statement we have only one "if" block, and only one "else" block - but we can have as many "else-if"
		 * blocks as we wish. This is known as a "if-else ladder".
		 */
		num = 100;
		
		if(num < 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		} else if (num < 100) {
			System.out.println(num + ", The variable \"num\" is more than 100");
		} else { // Last else not needed
			System.out.println(num + ", The variable \"num\" is exacly 100");
		}
		
		/*
		 * Nested if
		 * 
		 * When there is an if statement encapsulated within another if statement, this is referred to as a nested if statement.
		 * 
		 * The code within the outer if statement will only execute if it's conditional is found to be true. Otherwise, the code inside
		 * will be ignored. The code within our nested if is executed only if both the outer if conditional and its own conditional both
		 * evaluate to true.
		 */
		num = 64;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
			
			if(num % 2 == 0) {
				System.out.println("The variable \"num\" is even.");
			}
		}
		
		/*
		 * Switch
		 * 
		 * byte, short, char, int
		 * Character, Byte, Short, Integer, String
		 * 
		 * CHECK FOR MORE NOTES LATER
		 */
		String str = "Greeting";
		
		switch(str) {
		case "greeting":
			System.out.println("Hello there, fellow coder!");
			break; // without break satements we get fall-through!
		case "goodbye":
			System.out.println("Goodbye for now!");
			break;
		case "Greeting":
			System.out.println("Casing is important, huh?");
			break;
		default:
			System.out.println("RAWR!");
			break; // Don't need
		}
		
		/*
		 * Looping statements
		 * 
		 * Loops are used to execute a set of statements repeatedly until a particular condition is met. In
		 * Java, we have three basic looping structures:
		 * 
		 * 		- for
		 * 		- while
		 * 		- do-while
		 * 
		 */
		
		/*
		 * for
		 * 
		 * A for loop consists of the 'for' keyword, followed by a set of parenthesis that contain:
		 * 		- initialization step
		 * 		- conditional step
		 * 		- manipulation step (iterative step)
		 */
		
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		for(int i = 10; i > 3; i--) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		System.out.println("-----------");
		
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			if(i == 0) {
				System.out.print(i);
			} else {
				System.out.print("," + i);
			}
		}

		System.out.println("\n-----------");
		
		// break in loops means skip the following all together
		// continue in loops means skip the following and go back to the beginning of the loop
		
		for(int i = 0; i < 100; i+=3) {
			if(i == 0) {
				System.out.print(i);;
			} else {
				System.out.print(", " + i);
			}
		}
		
		System.out.println("\n-----------");
		
		// for (;;) valid, but is an infinite loop
		
		/*
		 * while
		 */
		
		num = 10;
		while(num > 1) {
			System.out.println(num);
			num--;
		}
		
		/*
		 * do-while
		 * 
		 * Will always execute once
		 */
		num = 0;
		
		do {
			System.out.println("This will execute at least once!");
		} while (num < 0);
	}
}
