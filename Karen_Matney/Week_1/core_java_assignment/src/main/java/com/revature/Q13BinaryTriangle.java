/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q13BinaryTriangle.java
 * Code for Q13 of Core Java Assignment. Print out a triangle of alternating 1's and 0's where height is equal to width, set to 4 characters.
 */
package com.revature;

public class Q13BinaryTriangle {
	public static void main(String[] args) {
		int triHeightWeight = 4;
		
		Q13BinaryTriangle.binaryTriangle(triHeightWeight);
	}
	
	public static void binaryTriangle(int triHeightWeight) {
		int counter = 0;

		for(int i = 0; i < triHeightWeight; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(counter++ % 2);
			}
			System.out.print('\n');
		}
	}
}