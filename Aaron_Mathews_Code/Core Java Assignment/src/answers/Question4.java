package answers;

public class Question4 {
	
	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
	
	public static int factorial(int n) {
		int answer = 1;
		for (int i = n; i > 0; i--) {
			answer *= i;
		}
		return answer;
	}

}
