package com.revature;
import java.util.ArrayList;

public class PrintPrimes {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<Integer>(100);

		for(int i = 1; i <= 100; i++) {
			arrayList.add(i);
		}

		ArrayList<Integer> primesArrayList = getPrimes(arrayList);

		System.out.println(primesArrayList.toString());

	}

	public static ArrayList<Integer> getPrimes(ArrayList<Integer> arrayList){
		
		ArrayList<Integer> primesList = new ArrayList<>();

		for (int j : arrayList) {
			int counter = 0; 
			for(int i = j; i >= 1; i--) {
				
				if (j % i == 0) 
					counter += 1;
				
			}
			
			if(counter == 2) 
				primesList.add(j);
			
		}
		return primesList;
	}
}
