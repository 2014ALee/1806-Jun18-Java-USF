package com.revature.drivers;

import java.util.Date;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {

	public static void main(String[] args) {
		Employee emp = new Employee("Wezley", "Developer", new Date());
	
		// Establish session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
		// Start the transaction
		session.beginTransaction();
	
		session.save(emp);
	
		session.getTransaction().commit();
		
		// Since the object is saved to the DB and was
		// in the persistent sate, it has an ID now.
		System.out.println("New employee added with id: " + emp.getId());
		
		// Terminate the SessionFactory , otherwise the application doesn't end.
		HibernateUtil.getSessionFactory().close();
	}
}
