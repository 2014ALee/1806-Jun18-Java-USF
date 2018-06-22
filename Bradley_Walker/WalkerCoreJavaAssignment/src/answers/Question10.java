package answers;

public class Question10 {
	// Finding the minimum of two numbers

	public static void main(String[] args) {
		int x = 7;
		int y = 7;
		
		System.out.println("min(" + x + ", " + y + ") = " + min(x, y));
	}
	
	// This function returns the smaller of two given numbers
	public static int min(int x, int y) {
		return (x < y) ? x : y;
	}

}
