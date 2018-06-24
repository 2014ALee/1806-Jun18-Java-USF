package homework_week1.questions;

public class Question4 {
	
	public static int computeFactorial(int input) {
	
	//this value is what we'll multiply our factorial by in each pass through the for loop
	//to get to our final value	
	int multiplyBy = input;
	
	//the factorial product get store hear
	int factorialProduct = multiplyBy;
	
	//if we pass in a 1, we know that the factorial is 1*1, which is 1
		if(input == 1) {
			return 1;
		}
			
		for(int i = 0; i < input - 2; i++){
		
		//we multiply the factorial value with the number one less than it	
		factorialProduct = factorialProduct * (multiplyBy - 1);
		
		multiplyBy--;
		}
		
		return factorialProduct;
	}
	
	public static void main(String[] args) {
	System.out.println(computeFactorial(0));		
	}

	
}
