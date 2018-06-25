package com.revature;

import java.util.ArrayList;
import java.util.List;

// store numbers 1-100 in an arrayList and print prime numbers to the console
public class Question9 {

	public static void main(String[] args) {
		
		List<Integer> numbers = new ArrayList<>();
		
		for(int i = 1; i < 101; i++)
			numbers.add(i);
		
		for(int num : numbers)
			if(isPrime(num))
				System.out.print(num + "   ");
	}
	
	public static boolean isPrime(int N) {
		if(N > 3) 
			for (int i = 2; i < N; i++)
				if((N % i) == 0)
					return false;
		return true;
	}
}
