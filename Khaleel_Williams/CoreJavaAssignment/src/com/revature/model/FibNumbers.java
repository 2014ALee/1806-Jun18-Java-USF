package com.revature.model;

public class FibNumbers {

		public int Fib(int x) {
			
			if (x == 1) {
				return 0;
			}else if(x == 2) {
				return 1;
			}else {
				int num = Fib(x-1) + Fib(x - 2);
				System.out.println(num);
				return num;
			}
		}
}
