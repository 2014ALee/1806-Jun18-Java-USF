package com.revature;
import static com.revature.models.MyStaticClassMembers.*;

public class StaticDriver {
	public static void main(String[] args)
	{
		//using a static import we no longer have to type "MyStaticClassMembers.INCREMENT"
		System.out.println("Increment value: "+ INCREMENT);
		
		//it also shortens the invocation of the static method 'incrementNumber()'
		int count = 10;
		System.out.println("Incrememn count "+ incrementNumber(count));
	}

}
