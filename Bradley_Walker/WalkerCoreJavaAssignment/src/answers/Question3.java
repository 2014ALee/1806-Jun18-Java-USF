package answers;

public class Question3 {
	// Reversing a String

	public static void main(String[] args) {
		String s = "This is a string";
		System.out.println("Original: " + s);
		// Reverse the string
		s = reverseString(s);
		System.out.println("Reversed: " + s);
	}
	
	public static String reverseString(String s) {
		// Store the string in a character array
		char[] chars = s.toCharArray();
		
		// Create a new array to store the characters in reverse order
		char[] result = new char[chars.length];
		
		// Loop through the character array and store the characters in reverse order
		// in the result array
		for(int i = 0; i < chars.length; i++) 
			result[i] = chars[(chars.length - 1) - i];
		
		// Return a new string from the result array
		return new String(result).intern();
	}

}
