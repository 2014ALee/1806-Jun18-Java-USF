package com.revature;

public class Question10 {
	public static void main(String[] args) {
		System.out.println(minimum(5,10));

	}
	/*
	 * Ternary operators go like this:
	 * Condition, followed by ?, followed by
	 * value returned if condition true, followed
	 * by :, followed by value returned if condition
	 * is false.
	 */
	public static int minimum(int a, int b) {
		return a < b ? a : b;
	}
}
