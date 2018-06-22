package homework_week1;

import java.util.ArrayList;

public class Question9 {

	public static void getPrimeInts(ArrayList<Integer> arrayList)	{
		//at first we assume we have no divisors
		int divisors = 0;

		//the outter for loop goes through ints 1 to 100 to see if they are prime
		for(int i = 1 ; i<=100 ; i++) {
			
			//the inner for loop divides each number by every number between 0 and it to see how many divisors it has
			for(int j = 1 ; j<=i; j++) {
				if(i % j == 0) {
					divisors++;
				}
			}
			
			//if we have exactly two divisors, we know that the number is prime. Thus, we add it to our array list
			if(divisors==2) {
				arrayList.add(i);
			}
			divisors=0;			
		}	
	}	

	public static void printArrayList(ArrayList<Integer> arrayList) {
		for(int i = 0 ; i<arrayList.size() ; i++) {
			System.out.println(arrayList.get(i));
		}
	}


	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		getPrimeInts(arrayList);
		printArrayList(arrayList);

	}
}
