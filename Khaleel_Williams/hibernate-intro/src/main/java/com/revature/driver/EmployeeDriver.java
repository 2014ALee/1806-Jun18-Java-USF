package com.revature.driver;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {

	public static void main(String[] args) {
		
		Employee emp = new Employee();
		emp.setName("Wezley");
		emp.setRole("Developer");
		emp.setInserTime(new Date());
		
		// Establish a session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
		// Start the transaction
		session.beginTransaction();
		
		// Save the Employee object to the DB
		session.save(emp);
		
		// Commit the transaction
		session.getTransaction().commit();
		
		// Since the object is saved to the DB, and was in the persistent state - it has an ID now
		System.out.println("New employee added with id: " + emp.getId());
		
		// Terminate the SessionFactory, otherwise the application doesn't end.
		HibernateUtil.getSessionFactory().close();
		
		
	}

}
