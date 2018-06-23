package com.revature;

public class NFactorial {
	
	public static void main(String[] args) {
		System.out.println(nFactFinder(8));
	}
	public static int nFactFinder(int n) {
		for(int i = n; i > 1; i--)
			if (i != 0)
				n = n * (i-1);
		return n;
	}
}
