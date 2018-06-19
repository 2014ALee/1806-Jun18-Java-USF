package com.revature;

public class ControlDriver {

	public static void main(String[] args) {
		
		/*
		 * Decision making statements:
		 * 	-if statements
		 * 	-if else
		 * 	-if else-if
		 * 	-nested if
		 * 	-switch statements
		 */
	
		//if/else-if
		//if a condition is met, it doesn't look at the rest
		int num = 100;
		
		if (num < 100) {
			System.out.println(num + ", The variable 'num' is less than 100");
		}
		else if (num > 100){
			System.out.println(num  + ", The variable 'num' is greater than 100");
		}
		else {
			System.out.println(num  + ", The variable 'num' is exactly 100");
		}
		
		/*
		 * Switch statement
		 */
		String str = "Greeting";
		
		switch (str) {
		
		case "greeting":
			System.out.println("casing doesnt matter.");
			break;
		case "goodbye":
			System.out.println("byebye");
			break;
		case "Greeting":
			System.out.println("casing is important.");
			break;
		default:
			System.out.println("nothing matched");
						
		}	
				
		/*
		 * loops - used to execute statements repeatedly until a condition is met
		 * -for
		 * -while
		 * -do while
		 * -for each
		 */
		
		//loop with multiple vars and conditions
		for (int i = 0, j = 10; i < 10 && j > 0; i++, j--) {
			System.out.println(i + ", " + j + ", i is less than 10 and j is greater than 0");
		}
		
		
		//loop and iterate by 3
		for (int i = 0; i < 20; i+=3) {
			System.out.println(i);
		}

		
		//while
		int number = 10;
		
		while (number > 1) {
			System.out.println(number);
			number--;
		}
		
		do {
			System.out.println("This will execute atleast once.");
		}while(number < 0);
	}
}
