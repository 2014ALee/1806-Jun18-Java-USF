package answers;

public class Question6 {
	
	public static void main(String[] args) {
		System.out.println(isEven(10));
	}
	
	public static boolean isEven(int n) {
		double test = n / 2.0;
		return (test == Math.floor(test) ? true : false);
	}

}
