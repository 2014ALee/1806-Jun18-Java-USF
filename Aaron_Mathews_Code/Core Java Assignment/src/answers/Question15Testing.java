package answers;

public class Question15Testing {
	public static void main(String[] args) {
		Question15Impl impl = new Question15Impl();
		double a = 5.0;
		double b = 6.0;
		System.out.println(a + " + " + b + " = " + impl.addition(a, b));
		System.out.println(a + " - " + b + " = " + impl.subtraction(a, b));
		System.out.println(a + " * " + b + " = " + impl.multiplication(a, b));
		System.out.println(a + " / " + b + " = " + impl.division(a, b));
	}
}
