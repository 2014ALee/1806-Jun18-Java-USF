package com.revature;

import com.revature.models.Alpha;
import com.revature.models.Beta;

public class OopDriver {
	public static void main(String[] args) {
		
		Alpha alpha = new Alpha();
		System.out.println(alpha.myPublicInt); // 9
		
		Beta beta = new Beta();
		System.out.println(beta.myPublicInt); // 9
		System.out.println(beta.shadowGetter()); // 1
		
		//covariance
		Alpha obj = new Beta(); // 1
		System.out.println(obj.myPublicInt);
	}
}
