package com.revature;

public class IsEvenDriver {

	public static void main(String[] args) {
		Even(22);
	}

	public static boolean Even(int i) {

		if(i == ((i/2) * 2)){

			System.out.println("It's an EVEN number");
			return true;
		} else {

			System.out.println("Not an even number");
			return false;
		}
	}
}
