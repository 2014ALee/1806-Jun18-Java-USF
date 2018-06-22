package com.revature;

public class Question3 {

	public static void main(String[] args) {
		System.out.println("hiking");
		System.out.println(reverseWithoutTempVar("hiking"));
	}
	
	public static String reverseWithoutTempVar(String input) {
		for (int i = 0; i < input.length(); i++) {
			/*
			 * Inserting the last character into the current
			 * index of the String (and taking it out of the end.
			 * This is done by concatenating the substring before the index,
			 * the last character, and then the rest of the string
			 * (aside from the last character).
			 * [i = 0]hell[o], "" + 'o' + "hell"
			 * o[i = 1]hel[l], "o" + 'l' + "hel"
			 * ol[i = 2]he[l], "ol + 'l' + "he"
			 * oll[i = 3]h[e], "oll" + 'e' + "h"
			 * olle[i = 4][h], "olle" + 'h' + ""
			 */
			input = input.substring(0, i) + input.charAt(
					input.length() - 1) + input.substring(
							i, input.length() - 1);
		}
		return input;
	}

}
