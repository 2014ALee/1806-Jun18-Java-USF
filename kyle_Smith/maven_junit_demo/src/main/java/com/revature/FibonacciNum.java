package com.revature;
import java.util.Arrays;

public class FibonacciNum {
	public static void main(String[] args) {
		FibonacciNum fibNum = new FibonacciNum();
		int[] fibArray = fibNum.fibNums(25);
		System.out.println(Arrays.toString(fibArray));
	}
	public int[] fibNums(int num) {
		int[] fib = new int[num];
		for(int i = 0; i < fib.length; i ++) {
			if (i == 0)
				fib[i] = 0;
			else if (i == 1)
				fib[i] = 1;
			else
				fib[i] = fib[i-2] + fib[i-1];
		}
		return fib;
	}
}
