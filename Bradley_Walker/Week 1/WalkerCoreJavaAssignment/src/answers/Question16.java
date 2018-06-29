package answers;

public class Question16 {
	// Using command line arguments

	public static void main(String[] args) {
		System.out.println(numChars(args[0]));
	}
	
	public static int numChars(String s) {
		return s.length();
	}

}
