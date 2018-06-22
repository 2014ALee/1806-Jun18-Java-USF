package answers;

public class Question13 {
	// Printing weird triangle

	public static void main(String[] args) {
		// b controls whether it prints 0 or 1
		boolean b = false;
		// Outer loop is row
		for(int i = 1; i <= 4; i++) {
			// Inner loop is column
			for(int j = 0; j < i; j++) {
				System.out.print((b) ? 1 : 0);
				// Switch output
				b = !b;
			}
			System.out.println();
		}
	}

}
