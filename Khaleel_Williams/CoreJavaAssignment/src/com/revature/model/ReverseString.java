package com.revature.model;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseString {
	
	public static void reverse(String str) {
		
		
		Deque<String> i = new LinkedList();

		
		for (String s : str.split("") ) {
			
			i.addFirst(s);	
		}
		
		for (String t : i) {
			System.out.print(t);
		}
	}

}
