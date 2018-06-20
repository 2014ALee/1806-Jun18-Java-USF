package answers;

public class Question4 {
	// Factorial
	
	public static void main(String[] args) {
		int num = 5;
		
		int result = factorial(num);
		
		System.out.println(num + "! = " + result);
	}
	
	// Recursive function that calculates the factorial of a number.
	// If num is 1, it returns 1, else it returns num * fact(num - 1)
	public static int factorial(int num) {
		return (num == 1) ? 1 : num * factorial(num - 1);
	}

}
