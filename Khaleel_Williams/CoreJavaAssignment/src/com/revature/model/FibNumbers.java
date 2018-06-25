package com.revature.model;

public class FibNumbers {

	public static void main(String[] args) {

		findFib(10);
	}
	
	
	public static void findFib(int x) {
		
		for(int i = 1; i <= x; i++) {
			System.out.println(fib(i));
		}
		
	}
	
	public static int fib(int x) {

		if (x == 1) {
			return 0;
		}else if(x == 2) {
			return 1;
		}else {
			int num = fib(x-1) + fib(x - 2);
			return num;
		}
	}
}
