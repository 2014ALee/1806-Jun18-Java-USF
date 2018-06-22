package answers;

public class Question15 {

	public static void main(String[] args) {
		int x = 6;
		int y = 3;
		
		Question15Impl calculator = new Question15Impl();
		System.out.println(calculator.add(x, y));
		System.out.println(calculator.subtract(x, y));
		System.out.println(calculator.multiply(x, y));
		System.out.println(calculator.divide(x, y));
		
	}

}
