package homework_week1;

import java.util.ArrayList;

public class Question9 {

	public static void printPrimeInts(ArrayList<Integer> arrayList)	{

		System.out.println("Prime Numbers:");

		//the outter for loop goes through ints 1 to 100 to see if they are prime
		for(int i = 1 ; i<=100 ; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}	
	}	

	public static boolean isPrime(int myInt) {

		//at first we assume we have no divisors
		int divisors = 0;

		//the inner for loop divides each number by every number between 0 and it to see how many divisors it has
		for(int j = 1 ; j<=myInt; j++) {
			if(myInt % j == 0) {
				divisors++;
			}
		}

		//if we have exactly two divisors, we know that the number is prime. Thus, we add it to our array list
		if(divisors==2) {
			return true;
		}		

		return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		printPrimeInts(arrayList);

	}
}
