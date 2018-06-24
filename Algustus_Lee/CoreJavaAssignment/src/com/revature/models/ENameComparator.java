package com.revature.models;

import java.util.Comparator;

/*
 * This algorithm is the exact same as the one used in EDepartmentComparator.
 */

public class ENameComparator implements Comparator<Employees>{
	@Override
	public int compare(Employees e1, Employees e2) {
		int smallerString = 0;
		
		String e1String = e1.getName().toLowerCase();
		String e2String = e2.getName().toLowerCase();
		
		if(e1String.equals((e2String)))
		{
			return 0;
		}
		if(e1String.length() > e2String.length())
		{
			smallerString = e2String.length();
		}
		else
		{
			smallerString = e1String.length();
		}
		
		for(int i = 0; i < smallerString;i++)
		{
			if(e1String.charAt(i) > e2String.charAt(i))
			{
				return 1;
			}
			else if(e1String.charAt(i) < e2String.charAt(i))
			{
				return -1;
			}
		}
		return 0;
	}

}
