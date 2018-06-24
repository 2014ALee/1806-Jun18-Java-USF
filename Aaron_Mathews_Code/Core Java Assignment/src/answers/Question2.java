package answers;

public class Question2 {
	
	public static void main(String[] args) {
		fibonnaciNumber();
	}
	
	public static void fibonnaciNumber() {
		int[] fn = new int[25];
		fn[0] = 0;
		fn[1] = 1;
		for (int i = 2; i < fn.length; i++) {
			fn[i] = fn[i - 1] + fn[i - 2];
		}
		for (int i = 0; i < fn.length; i++) {
			System.out.println((i + 1) + " " + fn[i]);
		}
	}

}
