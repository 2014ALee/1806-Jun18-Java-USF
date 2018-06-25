/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q7EmployeeComparator.java
 * Code for Q7 of Core Java Assignment. Code to use to put into .sort() to sort an ArrayList of Employees.
 */
package com.revature.models;

import java.util.Comparator;

public class Q7EmployeeComparator implements Comparator<Q7Employee>{

	// The compare function required by Comparator
	@Override
	public int compare(Q7Employee e1, Q7Employee e2) {
		int strCompare;

		// Names
		strCompare = compareString(e1.getName(),e2.getName());
		if(strCompare == 1) {
			return 1;
		} else if(strCompare == -1) {
			return -1;
		} else {
			strCompare = compareString(e1.getDepartment(),e2.getDepartment());
			if(strCompare == 1) {
				return 1;
			} else if(strCompare == -1) {
				return -1;
			} else {
				if(e1.getAge() > e2.getAge()) {
					return 1;
				} else if(e1.getAge() < e2.getAge()) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	// A function to compare strings
	public int compareString(String str1, String str2) {
		int s1Length = str1.length();
		int s2Length = str2.length();

		// Take the minimum length to avoid ArrayOutOfBoundsException
		int min = (s1Length < s2Length) ? s1Length : s2Length;

		// Compare them character by character until the end of the line, returning once there's not a match
		for(int i = 0; i < min; i++) {
			if(str1.charAt(i) > str2.charAt(i)) return 1;
			if(str1.charAt(i) < str2.charAt(i)) return -1;
		}

		// The longer string goes last
		if(s1Length == s2Length) return 0;
		else if(s1Length > s2Length) return 1;
		else return -1;
	}
}
