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
		
		for(int num : getEvens(nums))
			System.out.print(num + " ");
	}
	
	public static int[] getEvens(int[] nums) {
		ArrayList<Integer> evens = new ArrayList<>();
		for(int num : nums) {
			if(Question6.isEven(num))
				evens.add(num);
		}
		
		int[] result = new int[evens.size()];
		for(int i = 0; i < evens.size(); i++)
			result[i] = evens.get(i);
		
		return result;
	}
}
