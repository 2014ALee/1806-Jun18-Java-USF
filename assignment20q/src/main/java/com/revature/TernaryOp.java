package com.revature;

public class TernaryOp {

	public static void main(String[] args) {
		int int1 = 12;
		int int2 = 12;
		TernaryOp tern = new TernaryOp();
		System.out.println(tern.minValue(int1, int2));
		
	}
	public int minValue(int int1, int int2) {
		int minNum;
		minNum = (int1 > int2) ? int2 : (int1 < int2) ? int1 : int1;
		return minNum;
	}
}
