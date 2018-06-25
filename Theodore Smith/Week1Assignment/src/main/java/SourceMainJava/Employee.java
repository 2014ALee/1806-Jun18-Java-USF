package SourceMainJava;

import java.util.Comparator;

public class Employee implements Comparator{
	@Override

	public int compare(EmployeeProblem e1, EmployeeProblem e2) {

		

		if(EmployeeProblem.getVin() - EmployeeTester.getVin() > 0) {

			return 1;

		} else if(EmployeeProblem.getVin() - EmployeeTester.getVin() < 0) {

			return -1;

		} else {

			return 0;

		}

	}



}

}
