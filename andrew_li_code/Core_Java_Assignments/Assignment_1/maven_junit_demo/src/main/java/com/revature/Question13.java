package com.revature;

public class Question13 {
	private static String printedString = "";
	
	public static void main(String[] args) {
		String printed = "";
		/*
		 * Each line gets changed, but there's
		 * so we create a string that changes.
		 * We can label the lines 1 through 4.
		 */
		for (int i = 1; i <= 4; i++) {
			/*
			 * In lines 1 and 4, 0 gets appended.
			 * In lines 2 and 3, 1 gets appended.
			 * If we take the remainders of 1 and 4
			 * after dividing by 4, we get 1 and 0.
			 * If we take the remainders of 2 and 3
			 * after dividing by 4, we get 2 and 3.
			 * We can get 0 from inputs 0 and 1 by 
			 * doing an integer division of 2,
			 * same that we can get output 1 from inputs
			 * 2 and 3 by doing an integer division of
			 * 2.
			 */
			int appended = i % 4 / 2;
			
			/*
			 * When the line number is even, we
			 * append from the front.
			 * When the line number is odd, we 
			 * append to the back. Line 1 
			 * appends to both front and back since
			 * it's only one character, but we
			 * can follow this for consistency purposes.
			 */
			if (i % 2 == 0) {
				printed = appended + printed;
			}
			else {
				printed += appended;
			}
			
			// Finally it's time to print.
			System.out.println(printed);
			printedString += printed + "\n";
		}
	}
	
	public static String getPrinted() {
		return printedString;
	}
}
