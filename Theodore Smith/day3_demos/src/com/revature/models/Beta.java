package com.revature.models;

public class Beta extends Alpha {
	
	public int myPublicInt = 9;
	
	public int shadowGetter( ) {
		return super.myPublicInt;
	}

}
