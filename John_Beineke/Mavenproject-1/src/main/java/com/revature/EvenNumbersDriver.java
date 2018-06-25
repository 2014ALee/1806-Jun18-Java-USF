package com.revature;
import java.util.ArrayList;

public class EvenNumbersDriver {

	public static void main(String[] args) {

		ArrayList<Integer> arrayList = new ArrayList<>(100);

		for(int i = 1; i < 100; i++) {
			arrayList.add(i);
		}
		
		for(int num : arrayList) {
			isEven(num);
		}
		
	}
	
	public static boolean isEven(int num) {
		
		if ((num%2) == 0) {
			System.out.println(num);
			return true;
		}
		else {
			return false;
		}
	}

}
