package com.revature;
// sort employess by implementing comparator
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.EmployeeComparator;

public class Question7 {

	public static void main(String[] args) {
		
		Employee emp1 = new Employee("Brandon", "Physics", 22);
		Employee emp2 = new Employee("Brandon", "physics", 20);
		Employee emp3 = new Employee("Brandon", "chemistry", 20);
		Employee emp4 = new Employee("Brandon", "Mathematics", 20);
		Employee emp5 = new Employee("Andrew", "Physics", 20);
		Employee emp6 = new Employee("Andrew", "physics", 21);
		Employee emp7 = new Employee("Andrew", "Chemistry", 22);
		Employee emp8 = new Employee("Andrew", "Philosophy", 23);
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		employees.add(emp6);
		employees.add(emp7);
		employees.add(emp8);
		
		for(Employee emp : employees)
			System.out.println(emp);
		
		System.out.println("---------------------------------------------------------");
		
		EmployeeComparator employeeComparator = new EmployeeComparator();
		
		employees.sort(employeeComparator);
		
		for(Employee emp : employees)
			System.out.println(emp);
	}
}
