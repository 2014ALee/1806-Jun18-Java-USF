package SourceMainJava;


public class problemThree {
	
		// input the string we want to reverse 
		
		private static String hello = "Theodore Smith";
		
		// make a class that we can to print the statement out 
		public static void main(String[] args) {
			
		
		System.out.println(reverseString(hello));
		
		}
		
		public static String reverseString(String s) {
		
		//  This is were we call the character at in a array and we call the string above.
		char letter[] = s.toCharArray();
		
		int start = 0;
		
		int finish = letter.length -1;
		
		//Start from the beginning in string to the end reverse it.
		
		while(finish > start) {
			
			char temp = letter[start];
			
			letter[start] = letter[finish];
			
			letter[finish] = temp;
			
			start++;
			
			finish--;
			// Called the order from start 0 to finish of length and  
		}
		
		return new String(letter);

	}
}
