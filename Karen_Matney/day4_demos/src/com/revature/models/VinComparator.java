package com.revature.models;

import java.util.Comparator;

public class VinComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		if(o1.getVin() - o2.getVin() > 0) {
			return 1;
		} else if (o1.getVin() == o2.getVin()) {
			return 0;
		} else {
			return -1;
		}
	}
	
}
