package com.revature.model;

import java.util.Comparator;

public class SortUsingComparator implements Comparator<Employees>{

	
	@Override
	public int compare(Employees o1, Employees o2) {
		
		if (o1.getAge() > o2.getAge()) {
			return 1;
		} else if (o1.getAge() < o2.getAge()) {
			return -1;
		} else {
			return 0;
		}
		
	}
	
	
}
