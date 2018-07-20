package com.revature.drivers;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {

	public static void main(String[] args) {

		Employee emp = new Employee();
		emp.setName("John");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		// Establish a session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// start the transaction
		session.beginTransaction();
		
		// save the employee object to the database
		session.save(emp);
		
		// commit the transaction
		session.getTransaction().commit();
		
		// since the object is saved to the db and was in the persistent state - it has an ID now
		System.out.println("New employee added with ID: " + emp.getId());
		
		HibernateUtil.getSessionFactory().close();
	}

}
