package homework_week1;

public class FibonacciSequence {

	public static void showFibonacci(int seed1, int seed2, int nthNumber) {
		
		int firstNumber = seed1;
		int secondNumber = seed2;
		int toCalculate = 0;
		
		//below is the first two numbers in the sequence, printed to the console
		System.out.print(seed1 +", " + seed2);
		
		//the loop below prints out the 3rd to the nth (25th) fibonacci number
		for(int i=0;i<nthNumber;i++) {
			toCalculate = computeNextNumber(firstNumber, secondNumber);
			
			firstNumber=secondNumber;
			secondNumber=toCalculate;
			
			System.out.print(", " + toCalculate);
		}		
	}
	
	public static int computeNextNumber(int a, int b) {
		int c = a + b;	
		return c;
	}
	
	public static void main(String[] args) {
		showFibonacci(0,1,25);
	}
	
}
