package com.revature;

import com.revature.models.Alpha;
import com.revature.models.Beta;

//import com.revature.models.Alpha.*;
//import com.revature.models.Beta.*;

public class OopDriver {
	public static void main(String[] args) {
		Alpha alpha = new Alpha();
		System.out.println(alpha.myPublicInt);

		Beta beta = new Beta();
		System.out.println(beta.myPublicInt);
		System.out.println(beta.shadowGetter());

		// Variable Covariance
		Alpha obj = new Beta();
		System.out.println(obj.myPublicInt);

		// publicStaticIntGetter();

		Alpha.publicStaticIntGetter();
		Beta.publicStaticIntGetter();

		// MISSING (?)
	}
}