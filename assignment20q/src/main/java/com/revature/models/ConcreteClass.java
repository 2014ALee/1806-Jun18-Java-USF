package com.revature.models;

public class ConcreteClass extends SuperClass{
	private int num;
	private String str;
	private boolean check;
	public ConcreteClass() {
		num = 0;
		str = "";
		check = false;
	}
	public static void main(String[] args) {
		String str = "dog";
		String str2 = "10";
		ConcreteClass cc = new ConcreteClass();
		System.out.println(cc.hasUppercase(str));
		System.out.println(cc.makeUppercase(str));
		System.out.println(cc.convertStr(str2));
		
	}
	@Override
	public boolean hasUppercase(String str) {
		for(char s : str.toCharArray()) {
			if(Character.isUpperCase(s))
				return true;
		}
		return false;
	}
	@Override
	public String makeUppercase(String str) {
		int count = 0;
		String newString ="";
		for(char s : str.toCharArray()) {
			if(Character.isLowerCase(s))
				newString = newString + Character.toUpperCase(str.charAt(count));
			else
				newString = newString + str.charAt(count);
			count+=1;
		}
		return newString;
	}
	@Override
	public int convertStr(String str) {
		try {
			num = Integer.parseInt(str);
		}catch(NumberFormatException e) {
			System.out.println("Use a real number");
		}
		return num;
	}
	

	
}
