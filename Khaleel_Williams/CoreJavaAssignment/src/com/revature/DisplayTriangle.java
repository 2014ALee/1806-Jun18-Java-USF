package com.revature;

import java.util.Deque;
import java.util.LinkedList;

public class DisplayTriangle {
	
	public static void main(String[] args) {
		Triangle();
	}

	public static void Triangle() {

		Deque<Integer> i = new LinkedList();

		for(int x = 0 ; x < 4 ; x++) {
			if (i.size() == 0) {
				i.addFirst(0);
			} else if ((i.getFirst() == 0) && (i.getLast() == 0)) {
				i.addFirst(1);
			} else if ((i.getFirst() == 1) && (i.getLast() == 1)) {
				i.addFirst(0);
			} else if ((i.getFirst() == 0) && (i.getLast() == 1)) {
				i.addLast(0);
			} else {
				i.addLast(1);
			}
			for (Integer e : i) {
				System.out.print(e);
			}
			System.out.println();
		}		

	}
}
