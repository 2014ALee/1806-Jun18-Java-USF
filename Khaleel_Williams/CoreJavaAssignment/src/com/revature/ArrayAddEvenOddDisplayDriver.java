package com.revature;

import java.util.ArrayList;

public class ArrayAddEvenOddDisplayDriver {
	
	public static void main(String[] args ) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		for(int x = 1; x <= 100; x++) {
			arrayList.add(x);
		}
		
		displayArrayList(arrayList);
		
		System.out.println("Even numbers from 1-100 added = " + addEven(arrayList));
		System.out.println("Odd numbers from 1-100 added = " + addOdd(arrayList));
		
		for (int i : removePrime(arrayList)) {
			System.out.println(i);
		}

	}
	
	
	public static void displayArrayList(ArrayList<Integer> arrayList){
		
		for(int i : arrayList) {
			System.out.println(i);
		}	
	}
	
	public static int addEven(ArrayList<Integer> arrayList) {
		int num = 0;
		
		for (int i : arrayList) {
			if ((i % 2) == 0) {
				num += i; 
			}
		}
		
		return num;
	}
	
	public static int addOdd(ArrayList<Integer> arrayList) {
		int num = 0;
		
		for (int i : arrayList) {
			if ((i % 2) != 0) {
				num += i; 
			} 
		}
		
		return num;
	}
	
	public static ArrayList<Integer> removePrime(ArrayList<Integer> arrayList){
		
		arrayList = PrintPrimeNumbersDriver.getPrimeNumbers();
		return arrayList;
		
	}
	
	
	
	
}
