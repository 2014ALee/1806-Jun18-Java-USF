package com.revature;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * flow control	
 * Decision making
 * Looping
 * Branching
 */

public class ControlDriver {
	
	public static void main(String[] args) {
		
		
		/*
		 * Five types
		 * 	If statements
		 * 	If/else statements
		 *  If/else-if
		 *  Nested if
		 *  Switch
		 * 
		 */
		
		int num = 22;
		
		if(num<100) {
			System.out.println("The variable num is less than 100");
			if(num % 2 == 0) {
				System.out.println("the variable nun is even");
			}
			
		}else if(num>100) {
			System.out.println("The variable num isn't less than 100");
		}else {
			System.out.println("The variable is 100");
		}
		
		/*
		 * nested if 
		 * when there is an if statement encapsulated in another if statement it is a nested if
		 * 
		 * 
		 */
		
		/*
		 * 
		 * switch
		 * byte, short, char, int
		 * 
		 * 
		 */
		
		String str = "Greeting";
		switch(str) {
		case "greeting":
			System.out.println("Hello!");
			break;
		case "goodbye":
			System.out.println("Goodbyte for now!");
		    break;
		case "Greeting":
			System.out.println("casing is important");
			break;
		default:
			System.out.println("Nothing matched");
		}
		
		
		/*
		 * loops!
		 * 
		 * for
		 * while
		 * do while
		 * 
		 * break says leave loop
		 * continue says go on to the next iteration of the loop
		 * 
		 */
		
		for(int i = 0, j = 10; i < 10 && j>0; i++, j--) {
			//System.out.println("i is " + i);
			
			if(i == 0) {
				System.out.print(i);
			}else {
				System.out.print(", " + i);
			}		
		}
		
	int	number = 100;
		while(number>1) {
			System.out.println(number);
			number--;
		}
		
		number=5;
		
		do {
			System.out.println("this will go at least once");
			number--;
		}while(number>0);
		
		
	}
	
}
