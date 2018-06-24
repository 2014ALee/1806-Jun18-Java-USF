package answers;

public class Question16 {

	public static void main(String[] args) {
		String[] inputString = args;
		int numChar = charCounter(inputString);
		System.out.println("Number of characters = " + numChar);
	}
	
	public static int charCounter(String[] input) {
		String str = String.join(" ", input);
		return str.length();		
	}
	
}
