package com.revature;

/*
 * flow control refers to the practice of managing the way that our application eecutes
 * by using special statement types. These statement types include:
 * 	- Decision making statements
 * 	- looping statements
 * 	- branching statements
 */
public class ControlDriver {

	public static void main(String[] args) {
		/*
		 * Decision Making Statemnts
		 * 
		 * There are five types of decision making statements:
		 * 	- if statements
		 * 	- if/else statements
		 *  - if/else-if statements
		 *  - nested if statements
		 *  - switch statements
		 *
		 */
		
		/*
		 * If 
		 * An if statement consists of condition, followed by a statement or a set of statements.
		 * 
		 * The statements within the if block are only executed if the condition is found
		 *  to be true. Otherwise, the statments are ignored completely.
		 */
		
		int num = 72;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
			
		/*
		 * if/else
		 * 
		 * Syntatically the beginning of an if/else statement is identical to an if statement. 
		 * However, an additional else block (no conditional here!) is appended to the end of the 
		 * if block.
		 * 
		 * if the conditional evaluates to true, then the statments within the if block are executed,
		 * and the statements within the else block are ignored. Otherwise, the converse happens.
		 */
			
			num = 101;
			
			if (num < 100) {
				System.out.println(num + ", The variable \"num\" is less than 100");
			} else {
				System.out.println(num + ", The variable \"num\" is more than 100");
			}
			
		/*
		 * if/else-if
		 * 
		 * An if-else-if statement is used when we have multiple conditions that we wish to evaluate for.
		 * In this statement we have only one "if" block, and only one "else" block = but we can have as many "else-if"
		 * blocks as we wish. this is known as a "if-else ladder".
		 */
			
			num = 100;
			
			if (num < 100) {
				System.out.println(num + ", The variable \"num\" is less than 100");
			} else if (num > 100) {
				System.out.println(num + ", The variable \"num\" is more than 100");
			} else {
				System.out.println(num + ", The variable \"num\" is exactly 100");
			}
			
		/*
		 * Nested if
		 * 
		 * When there is an if statement encapsulated within another if statement, this is referred to as a nested
		 * if statement.
		 * 
		 * 
		 * The code within the outer if statement will only execute if its conditional is found to be true, Otherwise,
		 * the code inside will be ignored. The code within our nested if is executed only if both the outer if 
		 * conditional and its own conditional both evaluate to true.
		 */
			num = 64;
			
			if(num < 100) {
				System.out.println("num + \", The variable \\\"num\\\" is less than 100");
				
				if(num % 2 == 0) {
					System.out.println(num + ", The variable \"num\" is even.");
				}
			}
		/*
		 * switch
		 * 
		 * works with primitive type byte, short, char, and int
		 * works with wrapper classes Byte, Short, Character, Integer, String
		 * 
		 * Great for menu layouts
		 */
			String str = "greeting";
			
			switch(str) {
			case "greeting":
				System.out.println("Hello there, fellow coder!");
				break; //without break statements we get fall-through!
			case "googbye":
				System.out.println("Goodbye for now!");
				break; //ignore for now
			case "GREETING":
				System.out.println("Casing is important, huh?");
				break;
			default:
				System.out.println("Nothing matched...");
			}
			
		/*
		 * Looping statements
		 * 
		 * Loops are used to execute a set of statments repeatedly until a particular
		 * condition is met. In Java, we have thee basic looping structures:
		 * 
		 * 		-for
		 * 		-while
		 * 		-do-while
		 * 
		 */
			
		/*
		 * for 
		 * 
		 * A for loop consists of the 'for' keyword, followed by a set of parenthesis that contain:
		 * 		-initialization step
		 * 		-conditioanl step
		 * 		-manipulation step (iterative step)
		 */
			
		for (int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		System.out.println("----------------");
		
		for (int i = 10; i > 3; i--) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			if(i == 0) {
				System.out.print(i);
				continue;//skips that iteration, goes to next iteration
			}else { 
				System.out.print(", " + i);
			}
		}
		System.out.println("\n-------------");
		
		
		/*infinite loop
		 * 
		 * for(;;) {
			System.out.println("Hello!");
		}*/
		
		/*
		 * while
		 */
		
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
		} while (number < 0);
		
		}
	}
}
