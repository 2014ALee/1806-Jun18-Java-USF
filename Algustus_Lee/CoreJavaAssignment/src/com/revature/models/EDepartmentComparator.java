package com.revature.models;

import java.util.Comparator;

public class EDepartmentComparator implements Comparator<Employees>{

	
	@Override
	public int compare(Employees e1, Employees e2) {
		//makes an int to set the max length for the for loop. the max length is
		//the length of whichever string passed into it is smaller
		int smallerString = 0;

		//sets the e1.getDepartment().toLowerCase to something easier to type.
		//toLowerCase is used to keep caps from negatively affecting the sort
		String e1String = e1.getDepartment().toLowerCase();
		String e2String = e2.getDepartment().toLowerCase();

		//if the strings are the same, returns zero
		if(e1String.equals((e2String)))
		{
			return 0;
		}
		
		//sets which string is smaller
		if(e1String.length() > e2String.length())
		{
			smallerString = e2String.length();
		}
		else
		{
			smallerString = e1String.length();
		}

		//loops through both strings, but is capped at the length of the smaller string
		for(int i = 0; i < smallerString;i++)
		{
			//if the char value of e1's department is greater than that of e2's, return 1
			if(e1String.charAt(i) > e2String.charAt(i))
			{
				return 1;
			}
			//if the char value of e2's department is greater than that of e1's return -1
			else if(e1String.charAt(i) < e2String.charAt(i))
			{
				return -1;
			}
		}
		//if the other two don't get returned, return a 0
		return 0;
	}

}
