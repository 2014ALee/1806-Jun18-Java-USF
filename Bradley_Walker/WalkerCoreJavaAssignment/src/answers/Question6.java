package answers;

public class Question6 {
	// Detecting even integers
	// Assuming that 0 counts as even

	public static void main(String[] args) {
		int num = -39;
		String result = num + " is " + ((isEven(num)) ? "even" : "odd");
		System.out.println(result);
	}
	
	// This function returns true if the given integer is even
	// and false otherwise.
	public static boolean isEven(int num) {
		/*
		 * Hey look! I found a use for the right-shift operator!
		 * 
		 * When you right-shift an even number, you effectively
		 * divide it by 2. When you right-shift an odd number
		 * you effectively subtract 1 and then divide by 2.
		 * So if the number right-shifted times 2 is equal
		 * to the original number, it must be an even number.
		 */
		return ((num >> 1) * 2 == num);
	}

}
