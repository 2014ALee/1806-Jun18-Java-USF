package answers;

import java.util.ArrayList;

public class Question12 {
	// Print even numbers from an array

	public static void main(String[] args) {
		// Create the list
		int[] nums = new int[100];

		// Populate the list
		for(int i = 0; i < 100; i++)
			nums[i] = i+1;
		
		for(int num : nums)
			if(Question6.isEven(num))
				System.out.print(num + " ");
	}
}
