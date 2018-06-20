package answers;

import java.util.ArrayList;

public class Question2 {
	// Fibonacci Numbers

	public static void main(String[] args) {
		// Get the numbers
		ArrayList<Integer> fibs = fibonacci(25);
		
		// Print them out
		for(int i : fibs)
			System.out.print(i + " ");
	}
	
	// This method returns an ArrayList that contains the specified number
	// of Fibonacci numbers. (including 0)
	public static ArrayList<Integer> fibonacci(int num) {
		// This is the array that will contain the numbers
		ArrayList<Integer> fibs = new ArrayList<>();
		
		// We have to manually add the first 2 numbers in the sequence
		fibs.add(0);
		fibs.add(1);
		
		// This loop adds the previous 2 numbers in the sequence and inserts the result
		// into the ArrayList.
		for(int i = 2; i < num; i++)
			fibs.add(fibs.get(i-2) + fibs.get(i-1));
		
		return fibs;
	}

}
