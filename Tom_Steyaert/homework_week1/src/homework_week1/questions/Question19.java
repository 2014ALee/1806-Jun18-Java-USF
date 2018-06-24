package homework_week1.questions;

import java.util.ArrayList;

public class Question19 {

	public static int getEvenSum(ArrayList<Integer> myArrayList) {
		int evenSum = 0;

		for(int i = 0 ; i < myArrayList.size() ; i++) {

			if(Question6.isEven(myArrayList.get(i))) {
				evenSum += myArrayList.get(i);
			}
		}

		System.out.println("The even sum is: " + evenSum);		

		return evenSum;
	}

	public static int getOddSum(ArrayList<Integer> myArrayList) {
		int oddSum = 0;

		for(int i = 0 ; i < myArrayList.size() ; i++) {

			if(!Question6.isEven(myArrayList.get(i))) {
				oddSum += myArrayList.get(i);
			}
		}

		System.out.println("The odd sum is: " + oddSum);

		return oddSum;
	}

	public static ArrayList<Integer> removePrimes(ArrayList<Integer> myArrayList){

		for(int i = 0; i < myArrayList.size(); i++) {
			if(Question9.isPrime(myArrayList.get(i))) {
				myArrayList.remove(i);
				i--;
			}
		}		

		printArrayList(myArrayList);		

		return myArrayList;
	}


	public static void printArrayList(ArrayList<Integer> arrayList) {
		for(int i = 0 ; i<arrayList.size() ; i++) {
			System.out.println("ArrayList [" + i + "] = " + arrayList.get(i));
		}
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> myArrayList= new ArrayList<Integer>();	
		int arrayListSize = 10;


		for(int i = 1 ; i <= arrayListSize ; i++) {
			myArrayList.add(i);
		}

		printArrayList(myArrayList);		
		getEvenSum(myArrayList);
		getOddSum(myArrayList);
		removePrimes(myArrayList);

	}
}
