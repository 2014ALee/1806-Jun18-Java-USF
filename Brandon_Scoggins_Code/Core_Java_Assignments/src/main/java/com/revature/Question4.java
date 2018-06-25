package com.revature;
// Compute N factorial
public class Question4 {

	public static void main(String[] args) {
		int N = 6; // assume positive number				// manually change number to find factorial of
		System.out.println(factorial(N));					
	}
	
	private static int factorial(int N) {					// method to calculate the factorial of an int
		int nFactorial = N;
		for(int i = 1; i < N; i++) {						// multiplies N by every number between N-1 and 1 and stores the compound result in nFactorial
			nFactorial *= N - i; 
		}
		return nFactorial;									// returns the factorial
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
