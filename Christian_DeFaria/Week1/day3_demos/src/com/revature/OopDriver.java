package com.revature;

import com.revature.models.Alpha;
import com.revature.models.Beta;

//import static com.revature.models.alpha.*;
//import static com.revature.models.beta.*;

public class OopDriver {
	
	public static void main(String[] args) {
		Alpha alpha = new Alpha();
		System.out.println(alpha.myPublicInt);
		
		Beta beta = new Beta();
		System.out.println(beta.myPublicInt);
		System.out.println(beta.shadowGetter());
		
		//Covariance
		Alpha obj = new Beta();
		System.out.println(obj.myPublicInt);
		
//		publicStaticIntGetter();
	}

}
