package com.revature;

import com.revature.models.Alpha;
import com.revature.models.Beta;

public class OopDriver {
	public static void main (String[] args)
	{
		Alpha alpha = new Alpha();
		System.out.println(alpha.myPublicInt);
		
		Beta beta = new Beta();
		System.out.println(beta.myPublicInt);
		
		Alpha obj = new Beta(); //this is valid because beta extends Alpha. Beta is basically another Alpha.
		//All of the properties still point back to Alpha, however. This is called Covariance.
		System.out.println(obj.myPublicInt);
		
		System.out.println(beta.shadowGetter());
	}

}
