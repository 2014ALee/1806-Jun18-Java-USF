package com.revature;

import java.util.Arrays;

public class ArrayDriver {
	
	public static void main(String[] args) {
		int[] myArray = new int[20];
		for (int i = 0; i < 20; i++) {
			myArray[i] = i + 1;
		}
		System.out.println(Arrays.toString(myArray));
		myArray[10] = 100;
		System.out.println(Arrays.toString(myArray));
	
		String[] names = new String[10];
		names = new String[] { "Wezley", "Andrew", "Tom", "Al", "Teddy", "Simonisa", "Karl", "Joe", "Baron", "Kyle" };
		for (String name : names) {
			System.out.println(name);
		}
		
		int[][][] rooms = {{{100, 101, 102}, {110, 111, 112}, {120, 121, 122}},
				{{200, 201, 202}, {210, 211, 212}, {220, 221, 222}},
				{{300, 301, 302}, {310, 311, 312}, {320, 321, 322}}};
		System.out.println("__________________________________\n");
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				if (rooms[i][j].length > 0) {
					System.out.print(rooms[i][j][0]);
				}
				for (int k = 1; k < rooms[i][j].length; k++) {
					System.out.print(", " + rooms[i][j][k]);
				}
				System.out.println("");
			}
			System.out.println("__________________________________\n");
		}
		Object objectArray = new Object[20];
	}
}
