package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static SessionFactory buildSessionFactory() {
		try {
			
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			return config.buildSessionFactory();
			
		} catch (Throwable t) {
			
			t.printStackTrace();
			throw new ExceptionInInitializerError(t);
		}
		
	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			sessionFactory = buildSessionFactory();
		}
		
		return sessionFactory;
	}
	
	
}
