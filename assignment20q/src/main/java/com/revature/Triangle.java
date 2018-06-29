package com.revature;

public class Triangle {

	//	  0
	//    1 0
	//    1 0 1
	//    0 1 0 1

	public static void main(String[] args) {
		printTriangle(100);
	}

	public static void printTriangle (int size) {
		int count = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j <= i; j++) {
				if(count == 0) {
					System.out.print("0");
					count = 1;
				}else {
					System.out.print("1");
					count = 0;
				}
			}
			System.out.println("");
		}
	}

}
