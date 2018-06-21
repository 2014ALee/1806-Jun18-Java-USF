package homework_week1;

public class NFactorial {
	
	public static int computeFactorial(int input) {
	
	//this value is what we'll multiply our factorial by in each pass through the for loop
	//to get to our final value	
	int multiplyBy = input;
	
	int factorial = multiplyBy;
	
		if(input==1) {
			return 1;
		}
			
		for(int i=0; i<input-1; i++){
		factorial = factorial * (multiplyBy - 1);
		
		multiplyBy--;
		}
		
		return factorial;
	}
	
	public static void main(String[] args) {
	System.out.println(computeFactorial(10));		
	}

	
}
