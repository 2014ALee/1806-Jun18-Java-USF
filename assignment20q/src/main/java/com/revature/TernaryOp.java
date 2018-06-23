package com.revature;

public class TernaryOp {

	public static void main(String[] args) {
		int int1 = 12;
		int int2 = 12;
		int minNum;
		
		minNum = (int1 > int2) ? int2 : (int1 < int2) ? int1 : int1;
		System.out.println(minNum);
		
	}
}
