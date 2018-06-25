package com.revature;
// Compute N factorial
public class Question4 {

	public static void main(String[] args) {
		int N = 6; // assume positive number
		System.out.println(factorial(N));
	}
	
	private static int factorial(int N) {
		int nFactorial = N;
		for(int i = 1; i < N; i++) {
			nFactorial *= N - i; 
		}
		return nFactorial;
	}
	
	
	// Attempt with recursion (Unsuccessful)
//	private static int factorial(int N, int n) {
//		if (N == 0)
//			return n;
//		else if (N == 1)
//			return n;
//		else if (N > 1) {}
//			factorial(N - 1, n * (N - 1));
//			return n;
//	}
}
