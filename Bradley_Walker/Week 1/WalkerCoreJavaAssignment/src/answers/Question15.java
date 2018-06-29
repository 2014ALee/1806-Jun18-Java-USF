package answers;

public class Question15 {
	
	static Question15Impl calculator = new Question15Impl();
	
	public static int x = 6, y = 3;

	public static void main(String[] args) {
		System.out.println(addition());
		System.out.println(subtraction());
		System.out.println(multiplication());
		System.out.println(division());
		
	}
	
	public static double addition() {
		return calculator.add(x, y);
	}
	
	public static double subtraction() {
		return calculator.subtract(x, y);
	}
	
	public static double multiplication() {
		return calculator.multiply(x, y);
	}
	
	public static double division() {
		return calculator.divide(x, y);
	}

}
