package com.revature;

import java.util.ArrayList;

public class ArrayListQ19 {

	public static void question19() {
		
		ArrayList<Integer> number = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		ArrayList<Integer> odd = new ArrayList<>();
		int sumOfEvenNum = 0, sumOfOddNum = 0; 

		// Add element in number array list
		for(int i = 1; i <= 10; i++) {
			number.add(i);	
		}

		// Dyspaly the array list
		System.out.println("The array contains:");
		System.out.println(number);
		
		// Get even and add number from the array list
		for(int i : number) {
			if(i % 2 == 0) {
				even.add(i);
			}
			else {
				odd.add(i);
			}
		}
		
		// Sum the even number from the even array list
		
		for(int i : even) {
			sumOfEvenNum += i;
		}
		
		// Sum the add number from the odd array list
		
		for(int i : odd) {
			sumOfOddNum += i;
		}
		
		System.out.println("The even array contains:");
		System.out.println(even + " = " + sumOfEvenNum);
		
		System.out.println("The odd array contains:");
		System.out.println(odd + " = " + sumOfOddNum);
		
		for (int i = 2; i<number.size()-1; i++){
            if (isPrime(number.get(i))){
            	number.remove(number.get(i));
                i--;
            }
        }
		
		System.out.println("The non prime array contains:");
		System.out.println(number);
		
		
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
