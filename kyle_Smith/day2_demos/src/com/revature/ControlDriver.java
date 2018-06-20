package com.revature;

/*
 * Flow control refers to the practice of manging the way that your application executes by using
 * special statement types. these tatement types include:
 * 			
 * 		- decision making statements
 * 		-looping statements
 * 		- branching statements
 */
public class ControlDriver {

	
	public static void main(String[] args) {
		
		/*
		 * Decision making Statements
		 * 
		 * There are five types of decision making statements:
		 * 		- if statements
		 *  	- if/else-if statement
		 *   	- nested if statements
		 *   	- switch statements
		 */
		
		/*
		 * if
		 * 
		 * an if statements consists of a condition, followed by a statement or set of statements.
		 * 
		 * the statements within the if block are only executed if the conditions is found to be true.
		 * otherwise, the statements are ignored completly.
		 */
		
		int num = 72;
		if (num < 100)
			System.out.println(num +", The Variable 'num' is less than 100");
		
		/*
		 * if/else
		 * 
		 * Syntatically the beginning of an if/else statement is identical to an if statement. However,
		 * an additional else block (no conditional here!) is appended to the end of the if block.
		 * 
		 * if the conditional evluates to true, then the statements within the if block are executed, 
		 * and the statments within the else block are ignored. othwerise, the converse happens.
		 * 
		 */
		num = 101;
		
		if (num < 100)
			System.out.println(num + ", The Variable 'num' is less than 100");
		else
			System.out.println(num + ", The Variable 'num' is more than 100");

		/*
		 * if/else-if
		 * 
		 * an if-else-if statment is used when we have multiple conditions that we wisht o evualte for. in
		 * this statement we have only one "if" block and only one "else" block - but we can have as many
		 * "else-if" blocks as we wish. This is known as a "if-else ladder"
		 *
		 */
	
		if (num < 100)
			System.out.println(num + ", The Variable 'num' is less than 100");
		else if (num > 100)
			System.out.println(num + ", The Variable 'num' is more than 100");
		else
			System.out.println(num + ", The Variable 'num' is exactly than 100");
	
		/*
		 * Nested if
		 * 
		 * When there is an if statement encapsualted within another if statement, this is referred to
		 * as a nested if statement.
		 * 
		 * the code within the outer if statemnt will only execute if its conditional is found to be true.
		 * Otherwise, the code inside will be ignored. the code within our nested if is executed only if
		 * both the outer if conditional and its own conditional both evaluate to true.
		 */
		
		num = 64;
		
		if (num < 100) {
			System.out.println("The variable \"num\"is less than 100");
			
			if (num % 2 == 0)
				System.out.println("The variable \"num\" is even");
		}
		
		/*
		 * switch
		 * 
		 * 
		 */
		String str = "Greeting";
		
		switch(str) {
		case "greeting":
			System.out.println("Hello there, fellow coder!");
			break;//ignore
		case "goodbye":
			System.out.println("goodbye for now!");
			break;
		case "Greeting":
			System.out.println("Casing is important huh?");
			break;
		default:
			System.out.println("Nothing Matched...");
		}
		
		/*
		 * Looping statements
		 * 
		 * Loops are used to exectute a set of statements repeatedly until a particular condition is met.
		 * In Java, we have three basic looping structures:
		 * 
		 * 		-for
		 * 		-while
		 * 		-do-while
		 */
		
		/*
		 * for
		 * 
		 * A for loop conssits of the 'for' keyword, followed by a set of parenthessis that contain:
		 * 		-initialization step
		 * 		-conditional step
		 * 		-manipulation step (iterative step)
		 * 
		 */
		
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		System.out.println("--------------------------");
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			if(i==0)
				System.out.print(i);
			else
				System.out.print(", " + i);
		}
		System.out.println("\n--------------------------");
		
		int number = 10;
		
		while(number > 1) {
			System.out.println(number);
			number--;
		}
		
		/*
		 * do-while
		 */
		
		number = 0;
		
		do {
			System.out.println("This will execute at least once!");
		}while (number < 0);
	}
}



















