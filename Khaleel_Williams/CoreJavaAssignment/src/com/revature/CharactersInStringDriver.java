package com.revature;

public class CharactersInStringDriver {

	public static void main(String[] args) {
		System.out.print("There are " + numOfChar(args) + " characters in this string");
	}

	public static int numOfChar(String[] args) {

		if (args.length != 0) {
			char c[] = args[0].toCharArray();

			System.out.println(c.length);
			return c.length;
		} else {
			return 0;
		}

	}
}
