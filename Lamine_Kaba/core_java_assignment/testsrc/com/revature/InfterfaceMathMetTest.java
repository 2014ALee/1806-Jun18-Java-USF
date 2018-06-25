package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class InfterfaceMathMetTest {

	@Test
	public void test() {
		
		InterfaceMathMethos calculate = new InterfaceMathMethos();
		
		int i = 4; int j = 5;
		
		System.out.println(i +" + " + j +" is: " +calculate.add(i, j));
		System.out.println(i +" - " + j +" is: " +calculate.subtract(i, j));
		System.out.println(i +" * " + j +" is: " +calculate.mytiply(i, j));
		System.out.println(i +" / " + j +" is: " +calculate.divide(i, j));
	}

}
