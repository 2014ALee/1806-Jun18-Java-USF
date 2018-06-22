package answers;

import java.util.ArrayList;
import java.util.Arrays;

public class Question19 {
	// Amalgamation of stuff

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		
		// Print out the numbers
		System.out.print("Numbers: ");
		nums.forEach((Integer x)->System.out.print(x + " "));
		System.out.println();
		
		// Add all of the even numbers
		int evens = 0;
		for(int num : nums)
			if(Question6.isEven(num))
				evens += num;
		System.out.println("Sum of evens: " + evens);
		
		// Add all of the odd numbers
		int odds = 0;
		for(int num : nums)
			if(!Question6.isEven(num))
				odds += num;
		System.out.println("Sum of odds: " + odds);
		
		// Remove the primes
		nums.removeIf((Integer x)->Question9.isPrime(x));
		System.out.print("Numbers without primes: ");
		nums.forEach((Integer x)->System.out.print(x + " "));
	}
}
