package answers;

public class Question1 {
	// Bubble Sort

	public static void main(String[] args) {
		// This is the list of numbers to be sorted
//		int[] nums = {1,0,5,6,3,2,3,7,9,8,4};
		int[] nums = {4, 7, 1, 8, 5, 4, 5, 6, 7, 8, 7, 9, 2, 0, 0, 1, 7, 2, 1, 1, 3, 4, 0};
		
		nums = bubbleSort(nums);
		
		// Print out the sorted list
		for(int n : nums) {
			System.out.print(n);
		}
		
	}
	
	public static int[] bubbleSort(int[] nums) {

		// These variables will be used to keep track of which numbers we are examining
		int current = 0, last;
		
		// This boolean will control when the loop ends
		boolean cont = true;
		
		// Each iteration of this while loop is one pass over the list
		while(cont) {
			cont = false;
			
			// Here we are actually going through the list
			for(int i = 0; i < nums.length; i++) {
				// We set last = current and current equals the next number in the list
				last = current;
				current = nums[i];
				
				// If we're at the first number in the list, we can't really do anything
				// because we have nothing to compare it against. We just continue to the
				// next iteration.
				if(i == 0) continue;
				
				// If the current number is smaller than the previous number, switch the numbers.
				if(current < last) {
					// If we perform any switch, then we aren't done sorting and must continue on
					// with the while loop.
					cont = true;
					nums[i-1] = current;
					nums[i] = last;
					current = last;
				}
			}
		}
		
		return nums;
	}

}
