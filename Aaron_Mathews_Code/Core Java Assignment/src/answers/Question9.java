package answers;

import java.util.ArrayList;

public class Question9 {
	
	static ArrayList<Integer> myInts = new ArrayList<>();
	static ArrayList<Integer> primeInts = new ArrayList<>();
	
	public static void main(String[] args) {
		addInts(myInts);
//		System.out.println(myInts);
		checkPrimes(myInts);
//		System.out.println(primeInts);
	}
	
	public static void addInts(ArrayList<Integer> myInts) {
		for (int i = 0; i < 100; i++) {
			myInts.add(i+1);
		}
	}
	
	public static void checkPrimes(ArrayList<Integer> myInts) {
		for (Integer myInt : myInts) {
			if (myInt != 0 & myInt != 1) {
				if (isPrime(myInt)) {
					primeInts.add(myInt);
				}
			}
		}
	}
	
	public static boolean isPrime(Integer n) {
	    for (int i = 2; i < n; i++) {
	        if( n % i == 0)
	            return false;
	    }
	    return true;
	}

}
