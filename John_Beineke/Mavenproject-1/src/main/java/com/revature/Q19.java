package com.revature;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>(10);
		int evenTotal = 0;
		int oddTotal = 0;

		for(int i = 1; i <= 10; i++) {
			arrayList.add(i);
		}

		for(int i = 0; i < 10; i++) {
			System.out.print(arrayList.get(i) + ", ");
		}


		for(int i = 0; i < 10; i++) {		
			if(arrayList.get(i) % 2 == 0) {
				evenTotal += arrayList.get(i);
			}else {
				oddTotal += arrayList.get(i);
			}
		}
		System.out.println("\nEvens total = " + evenTotal);
		System.out.println("Odds total = " + oddTotal);

		ArrayList<Integer> primesArray = new ArrayList<>();
		primesArray = PrintPrimes.getPrimes(arrayList);
		
		System.out.println(primesArray.toString());

		arrayList.removeAll(primesArray);
		
		System.out.println(arrayList.toString());
		
		
		
	}

}
