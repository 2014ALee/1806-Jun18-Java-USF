package com.revature;

// Flow Control

public class ControlDriver {

	public static void main(String[] args) {
		/*
		 * Decision making statements
		 * if
		 * if/else
		 * if/else-if
		 * nested if
		 * switch
		 */
		
		System.out.println("Desicion Making Statements:");
		// if
		int x = 0;
		if(x == 0) {
			System.out.println("If");
		}
		
		// if/else
		if(x == 1) {
			System.out.println("If");
		}
		else {
			System.out.println("Else");
		}
		
		// if/else-if
		if(x == 1) {
			System.out.println("If");
		}
		else if(x == 0) {
			System.out.println("Else If");
		}
		else {
			System.out.println("Else");
		}
		
		// nested if
		int y = 1;
		if(x == 0) {
			if(y == 1) {
				System.out.println("Nested if");
			}
		}
		
		// switch
		x = 2;
		switch(x) {
		case 0:
			System.out.println("0");
			break;
		case 1:
			System.out.println("1");
			break;
		default:
			System.out.println("Switch");
		}
		
		/*
		 * Looping statement
		 * for
		 * while
		 * do while
		 */
		System.out.println("\nLooping Statements");
		
		int a = 0;
		System.out.println("For:");
		for(a = 0; a < 3; a++)
			System.out.print(a+1 + " ");
		System.out.println();
		
		System.out.println("While:");
		while(a < 6) {
			System.out.print(a+1 + " ");
			a++;
		}
		System.out.println();
		
		System.out.println("Do While:");
		do {
			System.out.print(a+1 + " ");
			a++;
		} while(a < 9);
		System.out.println();
	}
}
