package com.revature.drivers;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {
	public static void main(String[] args) {
		
		//Make an Employee object (transient)
		Employee emp = new Employee();
		emp.setName("blibbity");
		emp.setRole("Blob");
		emp.setInsertTime(new Date());
		
		//Establish a session
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		
		//Start the transaction
		session.beginTransaction();
		
		//Save the employee to the database
		session.save(emp);
		
		//commit the object to database
		session.getTransaction().commit();
		
		//since the object is saved in the Database, and was in the persistent state- it now has an ID
		System.out.println("New employee added with id: "+emp.getId());
		
		//Terminate the SessionFactory, otherwise the app never ends.
		HibernateUtil.buildSessionFactory().close();
	}

}
