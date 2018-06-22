package com.revature;

import com.revature.models.*;

public class OOPDriver {
	public static void main(String[] args) {
		Alpha alpha = new Alpha();
		System.out.println(alpha.myPublicInt);
		
		Beta beta = new Beta();
		System.out.println(beta.myPublicInt);
		
		Alpha obj = new Beta();
		System.out.println(obj.myPublicInt);
		System.out.println(beta.shadowGetter());
		
		Shape shape = new Circle();
		System.out.println(shape.type());
	}
}
