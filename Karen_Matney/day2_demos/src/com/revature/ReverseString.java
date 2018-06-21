/*
 * Jun 18, 2018
 * ReverseString
 * An in-class exercise to reverse a string
 */
package com.revature;

public class ReverseString {
	public String reverse(String str) {
		String reverse = "";

		for(int i = str.length()-1; i >= 0; i--) {
			reverse += (str.charAt(i));
		}

		return reverse;
	}

	public static void main(String[] args) {
		ReverseString str = new ReverseString ();
		System.out.println(str.reverse("String"));
	}
}