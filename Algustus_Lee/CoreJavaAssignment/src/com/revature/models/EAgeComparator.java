package com.revature.models;

import java.util.Comparator;
/*
 * the Age comparator was the easiest to make.
 */

public class EAgeComparator implements Comparator<Employees>{

	@Override
	public int compare(Employees e1, Employees e2) {
		//gets the ages. if the first age is greater than the second, it returns a negative
		//it returns a positive on vice versa, and a 0 if they are equal.
		if(e1.getAge() < e2.getAge())
		{
			return 1;
		}
		else if(e1.getAge() == e2.getAge())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

}
