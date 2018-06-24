package answers;

public class Question13 {
	// Printing weird triangle

	public static void main(String[] args) {
		System.out.println(generateTriangle());
	}

	public static String generateTriangle() {
		String triangle = "";
		
		// b controls whether it prints 0 or 1
		boolean b = false;
		// Outer loop is row
		for(int i = 1; i <= 4; i++) {
			// Inner loop is column
			for(int j = 0; j < i; j++) {
				triangle += ((b) ? 1 : 0);
				// Switch output
				b = !b;
			}
			triangle += "\n";
		}
		
		return triangle;
	}

}
