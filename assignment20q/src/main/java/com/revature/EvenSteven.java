package com.revature;

public class EvenSteven {
	
	public static void main(String[] args) {
		EvenSteven even = new EvenSteven();
		System.out.println(even.isEven(13));
	}
	public boolean isEven(int i) {
		boolean bool = false;
		if((i / 2d) == (i / 2))
			bool = true;
		return bool;
	}
}
