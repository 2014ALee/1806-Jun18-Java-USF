package homework_week1.questions;

public class Question2 {

	public static int showFibonacci(int seed1, int seed2, int nthNumber) {

		//the seeds are the first two values in the Fibonacci Sequence
		int firstNumber = seed1;
		int secondNumber = seed2;

		//this is the next number in our sequence
		int nextNumber = 0;

		//below is the first two numbers in the sequence, printed to the console
		System.out.print(seed1 +", " + seed2);

		//the loop below prints out the 3rd to the nth (25th) Fibonacci number
		for(int i = 0; i < nthNumber; i++) {
			nextNumber = computeNextNumber(firstNumber, secondNumber);

			firstNumber = secondNumber;
			secondNumber = nextNumber;

			System.out.print(", " + nextNumber);
		}		
		return nextNumber;
	}

	//this is the formula the Fibonacci Sequence employs to determine the next number
	public static int computeNextNumber(int a, int b) {
		int c = a + b;	
		return c;
	}

	public static void main(String[] args) {
		showFibonacci(0,1,23);
	}

}