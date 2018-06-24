package com.revature;

/*
 * Flow control refers to the practice of managing the way that our application executes by using special statement
 * types. these statements include: 
 * 
 * -Decision Making Statements
 * -Looping Statements
 * -Branching Statements
 */
public class ControlDriver{
	
	

	/*
	 * Decision Making Statements
	 * 
	 * -if statements
	 * -if/else statements
	 * -if/else-if statements
	 * -nested if statements
	 * -switch statements
	 */
	
	/*
	 * if
	 * 
	 * An if statement consists of a condition, followed by a statement or set of statements.
	 * 
	 * The statements within the block are only executed if the condition is found to be true. Otherwise, the block is ignored.
	 */
	
	
	
	if (num < 30)
	{
		System.out.println("The variable \"num\" is less than 30");
	}
	
	/*
	 * if/else
	 * 
	 * Syntactically, the beginning of an if/else statement is identical to an if statement. However, an additional else block
	 * (no conditional here!) is applied to the end of the if block.
	 * 
	 * If the conditional evaluates to true, then the statements within the if block are executed and the statements within
	 * the else block are ignored. Otherwise, the converse happens.
	 */
	
	/*
	 * if/else-if
	 * 
	 * An if/else-if statement is used when we have multiple conditions that we wish to evaluate for. In this
	 * statement we have only one "if" block, and only one "else" block. However we can have as many "else-if" blocks
	 * as we wish. This is known as an "if-else ladder".
	 */
	
	/*
	 * Nested if
	 * 
	 * When there is an if statement encapsulated within another if statement, this is referred to as a nested
	 * if statement. The code within the outer if statement will only execute if its conditional is found to be true.
	 * Otherwise, the code inside will be ignored. The code within our nested if is only executed if both the outer
	 * conditional and its own conditional both evaluate to true.
	 */
	
	/*
	 * switch
	 * 
	 * can have byte, short, char, and int values. 
	 */
	
	/*
	 * Looping statements
	 * 
	 * Loops are used to execute a set of statements repeatedly until a particular condition is met.
	 * In Java we have three basic looping structures:
	 * 
	 */
	
	/*
	 * for
	 * 
	 * a for loop consists of the 'for' keyword, followed by a set of parenthesis that contain:
	 * -Initialization step you can initialize more than one variable at a time.
	 * -conditional step
	 * -manipulation step.
	 */
	
	/*
	 * while
	 * 
	 * executes code within its block while the boolean associated with it has a value of true.
	 */
	
	/*
	 * do-while
	 * 
	 * int nnumber = 0;
	 * do { Sysout.printline("this happens once")
	 * while (nnumber < 0)
	 */
}
}
