package com.revature;

/*
 * Flow control refers to the practice of managing the way that our application executes by using
 * special statement types. These statement types include:
 *
 *     - Decision Making Statements
 *     - Looping Statements
 *     - Branching Statements
 */
public class ControlDriver {

	public static void main(String[] args) {
		
		/*
		 * Decision Making Statements
		 * 
		 * There are five types of decision making statements:
		 * 		- if statements
		 * 		- if/else statements
		 * 		- if/else-if statements
		 * 		- nested if statements
		 * 		- switch statements
		 */
		
		/*
		 * if Statements
		 *  
		 * An if statement consists a condition, followed by statement or a set of statements.
		 *  
		 * The statements gets executed only when the given condition is true. If the condition 
		 * is false then the statements inside if statement body are completely ignored.
		 */
		int num = 72;
		
		if(num < 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		}
		
		/*
		 * if/else Statements
		 * 
		 * Syntactically there the beginning of an if/else statement is identical to the if statement.
		 * However, an additional else block (no conditional here) is appended to the end.
		 * 
		 * The statements inside of the if block would execute if the condition is true, and the statements 
		 * inside the else block would execute if the condition is false.
		 */
		num = 101;
		
		if(num < 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		} else {
			System.out.println(num + ", The variable \"num\" is more than 100");
		}
		
		/*
		 * if/else-if Statements
		 * 
		 * An if-else-if statement is used when we need to check multiple conditions. In this statement we 
		 * have only one “if” and one “else”, however we can have multiple “else if”. It is also known as 
		 * if-else-if ladder.
		 * 
		 * The most important point to note here is that in if-else-if statement, as soon as the condition 
		 * is met, the corresponding set of statements get executed, rest gets ignored. If none of the condition 
		 * is met then the statements inside “else” gets executed.
		 */
		num = 100;
		
		if(num < 100) {
			System.out.println(num + ", The variable \"num\" is less than 100");
		} else if (num > 100) {
			System.out.println(num + ", The variable \"num\" is more than 100");
		} else {
			System.out.println(num + ", The variable \"num\" is exactly 100");
		}
		
		/*
		 * Nested if Statements
		 * 
		 * When there is an if statement inside another if statement then it is called the nested if statement.
		 * 
		 * The code within the outer if statement will execute if its conditional is true. The code inside of the 
		 * nested if statement will only execute if both the conditions the outer condition (otherwise, how would 
		 * it get to the nested if statement?) and its own condition are true.
		 */
		num = 64;
		
		if(num < 100) {
			System.out.println("The variable \"num\" is less than 100");
			
			if(num % 2 == 0) {
				System.out.println("The variable \"num\" is even.");
			}
		}
		
		/*
		 * switch Statements
		 * 
		 * A switch statement uses the 'switch' keyword followed by a set of parenthesis used to pass a value into the
		 * switch block. This value will then be compared to nested code blocks called 'cases'. Each case has a value
		 * associated to it that is compared to the value passed into the switch statement to determine if that case's
		 * code block should be executed. There can be an optional default block that will be executed if case none of
		 * the case conditions are met.
		 * 
		 * Unlike if/else-if statements, the switch statement can have a number of possible execution paths. A switch 
		 * works with the byte, short, char, and int primitive data types. It also works with enumerated types (Enum), 
		 * the String class, and a few special classes that wrap certain primitive types: Character, Byte, Short, and 
		 * Integer. 
		 * 
		 * There are more nuances to switch statements (such as the concept of "fall-through") that will be explored 
		 * later in the section on Branching Statements.
		 */
		String str = "greeting";
		
		switch(str) {
		case "greeting":
			System.out.println("Hello there, fellow coder!");
			break; // without break statements, we get fall-through!
		case "goodbye":
			System.out.println("Goodbye for now!");
		case "GREETING":
			System.out.println("Casing is important, huh?");
		default:
			System.out.println("Nothing matched...");
		}
		
		/*
		 * Looping Statements
		 * 
		 * Loops are used to execute a set of statements repeatedly until a particular condition is satisfied. In Java,
		 * there are three types of basic* loops:
		 *  
		 * 		- for
		 * 		- while
		 * 		- do-while.
		 * 
		 * * - There is another looping statement known as a for-each loop, or enhanced for-loop. This topic is covered in the section
		 * 	   on variable arguments
		 */

		/*
		 * for Loop
		 * 
		 * A for loop consists of the 'for' keyword, followed by a set of parenthesis that contain the initialization, conditional, and
		 * iteration logic of the loop itself, and the code block that will be executed. You can break the flow of a for loop down into
		 * four steps:
		 * 
		 * 	Step 1: 
		 * 		In for loop, initialization happens first and only one time, which means that 
		 * 		the initialization part of for loop only executes once.
		 * 	
		 * 	Step 2:
		 * 		Condition in for loop is evaluated on each iteration, if the condition is true 
		 * 		then the statements inside for loop body gets executed. Once the condition returns 
		 * 		false, the statements in for loop does not execute and the control gets transferred 
		 * 		to the next statement in the program after for loop.
		 * 
		 * 	Step 3:
		 * 		After every execution of for loop’s body, the increment/decrement part of for loop 
		 * 		executes that updates the loop counter.
		 * 	
		 * 	Step 4: 
		 * 		The program jumps back to Step 2 and condition is re-evaluated.
		 */
		
		// iterate through a loop from 0 to 4, incrementing i each time
		for(int i = 0; i < 5; i++) {
			System.out.println("The value of 'i' is: " + i);
		}
		System.out.println("---------------");
		
		// iterate through a loop from 10 to 4, decrementing i each time
		for(int i = 10; i > 3; i--) {
			System.out.println("The value of 'i' is: " + i);
		}
		
		/*
		 *  Any number of variables can be created during the initialization step, assessed during the conditional step, or manipulated 
		 *  during the iterative step. The conditional step, however, must resolve to a single boolean value. Also, we can nest other 
		 *  types of control statements inside our loops.
		 */
		for(int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			if(i == 0) {
				System.out.print(i);
			} else {
				System.out.print(", " + i);
			}
		}
		System.out.println("\n---------------");
	
		// There is no restriction of the way that you manipulate the initialized variables of the for loop during the iterative step.
		for(int i = 0; i < 100; i+=3) {
			if(i == 0) {
				System.out.println(i);
			} else {
				System.out.print(", " + i);
			}
		}
		
		System.out.println("\n----------------");
		
		/*
		 * In fact, there is not a requirement to have anything at all in any of the steps contained within the parenthesis. Although, the
		 * semi-colons are still necessary. This will create an infinite loop, and is commented out for proper execution of this example app.
		 */
//		for(;;) {
//			System.out.println("Hello!");
//		}
		
		/*
		 * while Loop
		 * 
		 * In a while loop, the condition is evaluated first and if it returns true then the statements inside while loop will execute. When 
		 * condition returns false, the control comes out of loop and jumps to the next statement after while loop.
		 * 
		 * The important point to note when using while loop is that the value of the conditional variable needs to be manipulated, and at some 
		 * point condition returns false. This way we can end the execution of while loop; otherwise, the loop would execute indefinitely.
		 */
		int number = 10;
		
		while(number > 1) {
			System.out.println(number);
			number--;
		}
		
		/*
		 * do-while Loop
		 * 
		 * Syntactically similar to a while loop, a do-while loop makes use of the 'do' keyword. The key difference between the do-while and
		 * while loops is simply that the code within the do block will execute first before the while conditional is ever evaluated. So,
		 * even if the while conditional evaluates to false the first time around, the code within the do block was still executed. If the 
		 * conditional evaluates to true, then the code within the do block is executed again. 
		 * 
		 * Like with a while loop, the developer should also be mindful of the need to manipulate the conditional variable. So as to ensure the
		 * proper execution of the loop.
		 */
		number = 0;
		do {
			System.out.println("This will execute at least once!");
		} while (number < 0);
		
		/*
		 * Branching Statements
		 * 
		 * Branching statements are keywords that allow us to break, or branch away, from the normal execution of some code - specifically when 
		 * within some control statement (decision-making or looping statements).
		 * 
		 * The keywords used for branching the logical flow of the application are:
		 * 		- continue
		 * 		- break
		 */
		
		/*
		 * break
		 * 
		 * The 'break' keyword is used to divert the execution of the code by exiting the current code block. It is most often employed within switch
		 * statements and looping statements.
		 * 
		 * In the case of switch statements, it is required to use breaks in order to prevent "fall-through". This occurs when the logic of a specific
		 * case does not break out of the switch statement. As a result, the application will simply continue to the logic of the next case (without 
		 * evaluating the case itself).
		 */
		String skill = "Java";
		
		
		// Without any breaks, this will execute every statement of every case after the case value is matched
		switch(skill) {
		case "Java":
			System.out.println("Java: Easily one of the best languages to learn.");
		case ".NET":
			System.out.println(".NET: Good to learn, but for some reason they put their curly braces on the wrong line");
		case "Python":
			System.out.println("Python: Who needs curly braces?");
		default:
			System.out.println(skill + ": Because...sure, why not.");
		}
		
		// Using a break within a for loop to exit it early
		for(int i = 1; i < 10; i++) {
			if(i % 3 == 0) {
				break;
			}
			System.out.println("i: " + i);
		}
		
		
		/*
		 * continue 
		 * 
		 * The 'continue' keyword is used to do exactly that, continue on to the next iteration of a loop. This is in contrast
		 * to the 'break' keyword which exits the current code block entirely.
		 */
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0)
				continue;
			else if(i % 15 == 0)
				System.out.println(i + ": FizzBuzz");
			else if(i % 5 == 0)
				System.out.println(i + ": Buzz");
			else if(i % 3 ==0)
				System.out.println(i + ": Fizz");
			else
				System.out.println(i);
		}
		
	}
}
