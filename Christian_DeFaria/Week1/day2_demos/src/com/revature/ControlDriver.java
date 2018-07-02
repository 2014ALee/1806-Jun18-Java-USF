package com.revature;

/*
 * Flow Control refers to the practice of managing the way that our application executes by using
 * special statement types. These statement types includes:
 * 
 * 	-Decision Making Statements
 * 	-Looping Statements
 * 	-Branching Statements
 */

public class ControlDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of decision making statements:
		 * 	if
		 * 	if/else
		 * 	if/else-if
		 * 	nested if
		 * 	switch
		 */
		
		/*
		 * if
		 * 
		 * An if statement consists of a condition, followed by a statement or set of statements.
		 * 
		 * The statement within the if block is only executed if the condition is found to be true.
		 * Otherwise, the statement is ignored.
		 */
		int num = 72;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
		}
		
		/*
		 * if/else
		 * 
		 * Syntacically the beginning of an if/else statement isn't different from an if statement. However,
		 * an additional else block (no conditions) is appended to the end of the block.
		 * 
		 * If the conditional evaluates to true, then the statements within the if block is executed,
		 * and the statements within the else block are ignored. Otherwise the converse happens.
		 */
		num = 101;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
		}
		else {
			System.out.println("The variable \"num\" is more than 100");
		}
		
		/*
		 * if/else-if
		 * 
		 * An if-else-if statement is used when we have multiple conditions that we wish to evaluate for. In
		 * this statement we have only one if block, and only one else block, but we can have as many else-if
		 * blocks as we wish. This is known as the else-if ladder.
		 */
		num = 100;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
		}
		else if (num > 100) {
			System.out.println("The variable \"num\" is more than 100");
		}
		else {
			System.out.println("The variable \"num\" is exactly 100");
		}
		
		/*
		 * Nested if
		 * 
		 * When there is an if statement encapsulated within another if statement, this is referred to as a nested if statement.
		 * 
		 * The code within the outer if statement will ony execute if its conditional is found to be true. Otherwise, the code inside
		 * will be ignored. The code within our nested if is executed only if both the outer conditional and its own conditional both
		 * evaluate to true.
		 */
		num = 64;
		
		if(num < 100 && num % 2 == 0) {
			System.out.println("The variable \"num\" is less than 100");
			//if(num % 2 == 0) {
				System.out.println("The variable \"num\" is even");
			//}
		}
		
		/*
		 * switch
		 * 
		 * byte, short, char, int
		 * Character, Byte, Short, Integer, String
		 */
		String str = "greeting";
		switch(str) {
			case "greeting":
				System.out.println("Hello there, fellow coder!");
				break;	//prevents fall through
			case "goodbye":
				System.out.println("Goodbye for now!");
				break;
			case "Greeting":
				System.out.println("Casing is important, huh?");
				break;
			default:
				System.out.println("Nothing matched");
		}
		
		/*
		 * Looping statements
		 * 
		 * Loops are used execute a set of statements repeatedly until a particular condition is met. In
		 * Java, we have three basic looping structures:
		 * 
		 * 	for
		 * 	while
		 * 	do-while
		 */
		
		/*
		 * For
		 * 
		 * A loop consisting of the 'for' keyword, followed by a set of parenthesis that contain:
		 * 	intialization step
		 * 	conditional step
		 * 	manipulation step
		 */
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		System.out.println("--------------");
		for(int i = 10; i > 3; i--) {
			System.out.println("The value of 'i' is: " + i);
		}
		System.out.println("--------------");
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			if(i==0)
				System.out.print(i);
			else {
				System.out.print(", " + i);
			}
		}
		System.out.println("\n--------------");
		
		for(int i = 0; i < 100; i+=3) {
			if(i==0)
				System.out.print(i);
			else {
				System.out.print(", " + i);
			}
		}
		System.out.println("\n--------------");
		
		/*
		 * While
		 * 
		 * 
		 */
		
		num = 10;
		
		while(num > 1) {
			System.out.println(num);
			num--;
		}
		
		/*
		 * do-while
		 * 
		 * 
		 */
		num = 0;
		
		do {
			System.out.println("This will execute at least once.");
		} while(num < 0);
	}

}
