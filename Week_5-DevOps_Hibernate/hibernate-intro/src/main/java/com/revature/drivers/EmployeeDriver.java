package com.revature.drivers;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDriver {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Create an Employee object (transient)
		Employee emp = new Employee();
		emp.setName("Blake");
		emp.setRole("Developer");
		emp.setInsertTime(new Date());
		
		
		// Establish a session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		
//		// Start the transaction
//		session.beginTransaction();
//		
//		// Save the Employee object to the DB
//		session.save(emp);
//		
//		// Commit the transaction
//		session.getTransaction().commit();
//		
//		// Since the object is saved the DB, and was in the persistent state - it has an ID now
//		System.out.println("New employee added with id: " + emp.getId());
//		
//		// Terminate the SessionFactory, otherwise the application doesn't end.
//		HibernateUtil.getSessionFactory().close();
		
		//--------------------------------------------------------------------------------------------
		
		// Start the transaction
		session.beginTransaction();
		
		// Get the named query defined in the named-queries.hbm.xml
		Query query = session.createNamedQuery("findEmployeeByName");
		query.setParameter("name", "Wezley");
		
		// Run the query and save its returned value to a collection variable
		List<Employee> employees = query.getResultList();
		
		// Print out employees retrieved from DB
		for(Employee e : employees) {
			System.out.println(e);
		}
		
		// Close the transaction
		session.getTransaction().commit();
		
		// Terminate the SessionFactory, otherwise the application doesn't end.
		HibernateUtil.getSessionFactory().close();
		
	}
	
}
