package answers;

public class Question5 {
	// Substring method. (reinventing the wheel)

	public static void main(String[] args) {
		String string = "12345";
		int num = 6;
		String result = subString(string, num);
		System.out.println(result);
	}

	// This method accepts a string and an index number as input
	// and returns a substring of the original string without
	// using the built in substring methods.
	public static String subString(String str, int idx) {
		// Subtract 1 because we want the substring to be between
		// 0 and idx - 1 inclusive.
		idx -= 1;
		// Convert the string to a character array
		char[] chars = str.toCharArray();
		// Create the array which will hold the substring
		char[] result = new char[idx];
		
		// Loop through the character array and move the desired
		// number of characters to the result array
		for(int i = 0; i < idx; i++)
			result[i] = chars[i];
		
		// Return the new string
		return new String(result);
	}
	
}
