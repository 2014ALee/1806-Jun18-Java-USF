package com.revature.models;

public class Beta extends Alpha {

	//The variable bellow is Shadowing because it is already declared in parent class
	public int myPublicInt = 9;
	
	public int shadowGetter() {
		return super.myPublicInt;
	}
	
	//Cannot reduce the visibility of inherited methods

//	@Override
//	private int getMyPublicInt() {
//		// TODO Auto-generated method stub
//		return super.getMyPublicInt();
//	}

	@Override
	public double getMyProtectedDouble() {
		// TODO Auto-generated method stub
		return super.getMyProtectedDouble();
	}

	@Override
	public char getMyPrivatChar() {
		// TODO Auto-generated method stub
		return super.getMyPrivatChar();
	}

	@Override
	public String getMyPackageString() {
		// TODO Auto-generated method stub
		return super.getMyPackageString();
	}

	@Override
	public int getMY_PUBLIC_FINAL_INT() {
		// TODO Auto-generated method stub
		return super.getMY_PUBLIC_FINAL_INT();
	}

	@Override
	public double getMY_PROTECTED_FINAL_DOUBLE() {
		// TODO Auto-generated method stub
		return super.getMY_PROTECTED_FINAL_DOUBLE();
	}

	@Override
	public char getMY_PRIVATE_FANAL_CHAR() {
		// TODO Auto-generated method stub
		return super.getMY_PRIVATE_FANAL_CHAR();
	}

	@Override
	public String getMY_PACKAGE_FINAL_STRING() {
		// TODO Auto-generated method stub
		return super.getMY_PACKAGE_FINAL_STRING();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
}
