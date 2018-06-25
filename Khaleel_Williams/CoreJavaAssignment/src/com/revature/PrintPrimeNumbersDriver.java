package com.revature;

import java.util.ArrayList;

public class PrintPrimeNumbersDriver {

	public static void main(String[] args) {
		for (int i : getPrimeNumbers()) {
			System.out.println(i);
		}
	}

	public static ArrayList<Integer> getPrimeNumbers() {

		//create arraylist
		ArrayList<Integer> arrayList = new ArrayList<>();
		ArrayList<Integer> newArrayList = new ArrayList<>();
		

		//add 1-100 into the list
		for (int x = 1 ; x <= 100 ; x++) {
			arrayList.add(x);
		}

		for (int i : arrayList) {
			
			if((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 7)) {
				newArrayList.add(i);
			} else if (((i % 2) == 0) || ((i % 3) == 0) || ((i % 5) == 0) || ((i % 7) == 0)){
				
			} else {
				//newArrayList.add(i);
			}
		}
		return newArrayList;

	}

}
