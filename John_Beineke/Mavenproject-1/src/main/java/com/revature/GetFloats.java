package com.revature;

import com.revature.models.FloatVariables;

public class GetFloats {

	public static void main(String[] args) {
		System.out.println(FloatVariables.float1);
		System.out.println(getFloat2());
}
	
	public static float getFloat1() {
		return FloatVariables.float1;
	}
	
	public static float getFloat2() {
		return FloatVariables.float2;
	}

}
