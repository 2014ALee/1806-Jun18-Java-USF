package com.revature;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.revature.models.BookInfo;
import com.revature.models.BookInfoId;

public class CompositeDriver {

	public static void main(String[] args) {
		
		// Create SessionFactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml") // not required, Hibernate will look for this file automatically
				.addAnnotatedClass(BookInfo.class)
				.buildSessionFactory();

		// Retrieve the Session from the SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			
			// Being a transaction
			session.beginTransaction();
			
			// Create the BookInfo object, using the Embeddable ID class
			BookInfoId id = new BookInfoId("Under the Dome", "Stephen King");
			BookInfo bookInfo = new BookInfo("9784167812287", id);
			
			// Save the BookInfo object
			session.save(bookInfo);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
	


}
