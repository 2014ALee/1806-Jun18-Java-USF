package com.revature;

import static day2_demos.MyStaticClassMember.*;

import day2_demos.MyStaticClassMember;
import day2_demos.MyStaticClassMember.*;

public class StaticDriver {

	

	public static void main(String[] args) {

		// using a static import we no longer have to type "MyStaticClassMembers.INCREMENT"

		System.out.println("Increment value: " + INCREMENT);

		

		int count = 10;

		

		// it also shortens the invocation of the static method 'incrementNumber()'

		System.out.println("Increment count: " + incrementNumber(count));

		

		MyStaticClassMember i = new MyStaticClassMember();

	}



}