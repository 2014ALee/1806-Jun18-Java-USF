/*
 * Karen Matney
 * June 23, 2018
 * Revature Training: Core Java Assignment
 * Q7EmployeeComparison.java
 * Code for Q7 of Core Java Assignment. Driver code for employee sort.
 */
package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Q7Employee;
import com.revature.models.Q7EmployeeComparator;

public class Q7EmployeeComparison {
	public static void main(String[] args) {
		List<Q7Employee> employees = new ArrayList<>();

		// Adding employees

		// OnName
		employees.add(new Q7Employee("Jane Smith","Sales",37));
		employees.add(new Q7Employee("Roger Smith","Sales",37));

		// OnDepartment
		employees.add(new Q7Employee("Roger Smith","Sales",26));
		employees.add(new Q7Employee("Roger Smith","IT",26));

		// OnAge
		employees.add(new Q7Employee("Jane Smith","Sales",37));
		employees.add(new Q7Employee("Jane,Smith","Sales",30));

		// Sorting employees
		sortEmployees(employees);

		for(Q7Employee employee : employees) {
			System.out.println(employee);
		}
	}
	
	public static List<Q7Employee> sortEmployees(List<Q7Employee> employees){
		Q7EmployeeComparator employeeComparator = new Q7EmployeeComparator();
		
		employees.sort(employeeComparator);
		
		return employees;
	}
}
