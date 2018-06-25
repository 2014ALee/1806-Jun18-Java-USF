package com.revature;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

// demonstrate the switch case with specific cases
public class Question14 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			menu(br);
		}
	}

	public static void menu(BufferedReader br) {
		System.out.println("Enter '1' to find the square root of a number.\n"
				+ "Enter '2' to display today's date.\n"
				+ "Enter '3' to split 'I am learning core Java' into a string array.");

		doAction(br, getInput(br));
	}

	public static String getInput(BufferedReader br) {
		String userInput = "";
		while(userInput == "") {
			System.out.print("\nYour choice: ");
			try {
				userInput = br.readLine();
				System.out.println();
				if(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3")) {
					System.out.println("Invalid input. Please enter '1', '2', or '3'");
					userInput = "";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return userInput;
	}

	public static void case1(BufferedReader br) {
		int userValue = -1;

		while(userValue < 0) {
			System.out.print("\nNumber to find the square root of: ");
			try {
				userValue = Integer.parseInt(br.readLine());
				System.out.println(userValue);
				if (userValue < 0) 
					System.out.println("Can't take the square root of a negative number.\n"
							+ "Enter a positive value.");
			} catch (IOException e) {
				e.printStackTrace();		// It may be safer to readLine then cast to char array and then to int
			}catch (NumberFormatException nfe) {
				System.out.println("\nExpected a numerical value.");
				nfe.printStackTrace();
			}
		}

		System.out.println("The square root of '" + userValue + "' is: " + Math.sqrt((double) userValue));
		System.out.println();
	}

	public static void case2() {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		System.out.println();
	}

	public static void case3() {
		String myString = "I am learning core Java";
		System.out.println("Storing '" + myString + "' as a string array...\n");

		char[] myCharArray = myString.toCharArray();

		int wordCount = 1;
		for(char character : myCharArray) {
			if(character == ' ')
				wordCount++;
		}

		String[] myStringArray = new String[wordCount];

		wordCount = 0;

		int wordStart = 0;
		int wordEnd = 0;
		for(int i = 0; i < myCharArray.length; i++) {
			if(myCharArray[i] == ' ') {
				wordEnd = i;
				myStringArray[wordCount++] = myString.substring(wordStart, wordEnd);
				wordStart = wordEnd + 1;
			}else if(i == (myCharArray.length - 1)) {
				wordEnd = i + 1;
				myStringArray[wordCount++] = myString.substring(wordStart, wordEnd);
				wordStart = wordEnd + 1;
			}
		}

		for(String str : myStringArray)
			System.out.println(str);
		System.out.println();
	}

	public static void doAction(BufferedReader br, String choice) {
		switch (choice) {
		case "1":
			case1(br);
			break;
		case "2":
			case2();
			break;
		case "3":
			case3();
			break;
		default:
			menu(br);
		}
	}
}
