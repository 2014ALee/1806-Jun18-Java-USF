package SourceMainJava;

import java.util.Arrays;

public class problemOne {


	public static void main(String[] args) {

		int[] num = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 }; //The number that need to be done in an order

		System.out.println("______________________________________________________\n"); 
		
		for(int i=0; i < num.length; i++) {
			for(int j=0; j < num.length - 1; j++) {
			
				if (num[j] > num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
				}
	    		System.out.println(Arrays.toString(num));
		
			} 
			System.out.println("______________________________________________________\n");
		}

	}

}
