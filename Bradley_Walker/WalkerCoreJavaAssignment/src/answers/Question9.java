package answers;

import java.util.ArrayList;

public class Question9 {
	// Detecting primes

	public static void main(String[] args) {
		// Create the lists
		ArrayList<Integer> nums = new ArrayList<>();
		ArrayList<Integer> primes = new ArrayList<>();

		// Populate the nums
		for(int i = 1; i <= 100; i++)
			nums.add(i);

		// Sort through and collect the primes
		for(int num : nums)
			if(isPrime(num))
				primes.add(num);

		// Print to the console
		for(int prime : primes)
			System.out.print(prime + " ");
	}

	// A simple function to check if a number is prime
	public static boolean isPrime(int num) {
		// 2 is the lowest prime
		if(num < 2) return false;
		// 2 is the only even prime
		if(num == 2) return true;
		// All other even numbers are odd
		if(num % 2 == 0) return false;
		/* Start at 3, 
		 end at the square root of the original number,
		 increment by 2.
		 This is a simple way to check all the relevant
		 potential factors.
		 */
		for(int i = 3; i * i <= num; i += 2)
			if(num % i == 0) return false;
		
		// If nothing evenly divides into it, then it must be prime
		return true;
	}

}
