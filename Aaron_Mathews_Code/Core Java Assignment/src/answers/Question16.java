package answers;

public class Question16 {

	public static void main(String[] args) {
		String[] inputString = args;
		charCounter(inputString);
	}
	
	public static void charCounter(String[] input) {
		String str = String.join(" ", input);
		System.out.println("Number of characters = " + str.length());		
	}
	
}
