package com.revature.models;

public class ReverseString {
	
	public static void main(String[] args) {
		
		String str = "test string";
		System.out.println("str = " + str);
		
        String[] chars = str.split("");
        String result = "";
        for(String s : chars) {  
        	System.out.println(s);
            result = s + result;
        }
        System.out.println(result);
		
		/*String s2="hello"; 
		String s1=new String("hello");   
		String s3=s1.intern();//returns string from pool, now it will be same as s2  
		System.out.println(s1==s2);//not equal  
		System.out.println(s2==s3);//equal
		*/
		
	}

}
