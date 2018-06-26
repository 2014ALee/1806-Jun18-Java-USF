package com.revature.warmup;

public class Hawk extends Raptor {

	public static void main(String[] args) {
		System.out.println("init");

		new Hawk();
		System.out.println("hawk");

		myLabel: {
			for(int i = 1; i < 10; i++) {
				
				if (i % 3 == 0) {
					break myLabel;
				} else {
					System.out.println(i);
				}
			}
			
			System.out.println("This should not print.");
		}
	}

}
