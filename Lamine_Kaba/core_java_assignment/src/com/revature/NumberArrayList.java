package com.revature;

import java.util.ArrayList;

public class NumberArrayList {

	public static void numberArrayList() {

		ArrayList<Integer> number = new ArrayList<>();
		ArrayList<Integer> myPrime = new ArrayList<>();

		// Add element in number array list
		for(int i = 1; i <= 100; i++) {
			number.add(i);	
		}

		// Copy number to myPrime array list
		//myPrime = number;
		System.out.println(number);

		for(int element : number) {
			myPrime.add(element);
		}

		System.out.println(myPrime.size());
		
		
		for (int i = 2; i<myPrime.size()-1; i++){
            if (!isPrime(myPrime.get(i))){
                myPrime.remove(myPrime.get(i));
                i--;
            }
        }
		System.out.println(myPrime);
	}
	
	public static boolean isPrime(int num){
        boolean prime = true;
        for (int i = 2; i < num; i++){
            if(num % i == 0){
                prime = false;  
            }
        }
        return prime;
    }
}
















