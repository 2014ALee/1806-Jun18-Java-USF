package SourceMainJava;

public class problemNine {

	public static void main(String[] args) {
		
		int i = 0;
		int num = 0;
		
		String primeNumbers = "";
		
//		Finding the primes from 1 to 100 need to include <= to include 100.
		for( i = 0; i <= 100; i++) {
			int count = 0;
			
			// have to do an increment and now a decrement to calculate for all the prime integers.
			for(num = i; num >= 1; num--) {
				
				if( i % num == 0) {
					
					count = count +1;
							
				}
			} if(count == 2) {
				
				// added the prime number to print to the console. and separated them.
				primeNumbers = primeNumbers + i + " ";	
			}
			
		}
		
		System.out.println("The Prime Numbers for 1 to 100 are: " );
		System.out.println(primeNumbers);
	}

}
