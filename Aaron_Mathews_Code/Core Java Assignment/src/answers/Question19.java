package answers;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			arrList.add(i+1);
		}
		System.out.println("ArrayList:");
		System.out.println(arrList.toString());
		System.out.println("------------------");

		System.out.println("Total of even numbers is: " + addEvens(arrList));
		System.out.println("------------------");
		
		System.out.println("Total of odd numbers is: " + addOdds(arrList));
		System.out.println("------------------");
		
		removePrimes(arrList);
	}

	public static int addEvens(ArrayList<Integer> arrList) {
		int total = 0;
		for (Integer num : arrList) {
			if (isEven(num)) {
				total += num;
			}
		}
		return total;
	}

	public static boolean isEven(Integer num) {
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}

	public static int addOdds(ArrayList<Integer> arrList) {
		int total = 0;
		for (Integer num : arrList) {
			if (!isEven(num)) {
				total += num;
			}
		}
		return total;
	}

	public static void removePrimes(ArrayList<Integer> arrList) {
		//Lambda used for removing primes to avoid ConcurrentModificationException
		//Kyle
		arrList.removeIf(num -> (isPrime(num) & num != 1));
		System.out.println("ArrayList without prime numbers is: " + arrList.toString());
		System.out.println("------------------");
	}

	public static boolean isPrime(Integer n) {
	    for (int i = 2; i < n; i++) {
	        if( n % i == 0)
	            return false;
	    }
	    return true;
	}

}
