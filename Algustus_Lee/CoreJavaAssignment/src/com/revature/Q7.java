package com.revature;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.EAgeComparator;
import com.revature.models.EDepartmentComparator;
import com.revature.models.ENameComparator;
import com.revature.models.Employees;

public class Q7 {
	public static void main(String[] args)
	{
		//gets input
		Scanner input = new Scanner(System.in);
		String theInput = new String();
		//sets and fills the employee arraylist
		List<Employees> employees = new ArrayList<Employees>();
		employees.add(new Employees("Bob", "Sales", 30));
		employees.add(new Employees("Jim", "Accounting", 28));
		System.out.println("Type what you want to sort by: ages, departments, or names");
		
		//in case of bad inputs
		try {
			theInput = input.nextLine();
			switch(theInput){
			//I made several comparators, one for each way to sort the list of employees.
			//The user types in which way they want to sort, and it calls up that particular
			//comparator to sort it.
			case "ages":
				EAgeComparator employeeLista = new EAgeComparator();
				employees.sort(employeeLista);
				System.out.println(employees);
				break;
			case "departments":
				EDepartmentComparator employeeListb = new EDepartmentComparator();
				employees.sort(employeeListb);
				System.out.println(employees);
				break;
			case "names":
				ENameComparator employeeListc = new ENameComparator();
				employees.sort(employeeListc);
				System.out.println(employees);
				break;
			default:
				System.out.println("Invalid input, try again.");
				main(args);
				
			}
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		input.close();
		
		
	}

}
