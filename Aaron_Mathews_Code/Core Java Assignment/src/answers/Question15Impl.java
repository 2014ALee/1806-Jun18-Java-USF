package answers;

public class Question15Impl implements Question15Interface {

	@Override
	public double addition(double a, double b) {
		double val = a + b;
		return val;
	}

	@Override
	public double subtraction(double a, double b) {
		double val = a - b;
		return val;
	}

	@Override
	public double multiplication(double a, double b) {
		double val = a * b;
		return val;
	}

	@Override
	public double division(double a, double b) {
		double val = a / b;
		return val;
	}

}
