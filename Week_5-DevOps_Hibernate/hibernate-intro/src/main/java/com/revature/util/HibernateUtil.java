package com.revature.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	//leveraging a singleton type design because session factory is a 'heavy' object meaning you only every want one.  The session is considered lightweight because its easy to create and destroy.
	private static SessionFactory buildSessionFactory() {
		try{
			//create the SessionFactory using the hiberante.cfg.xml file
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml"); //automatically looks for hibernate.cfg.xml if you don't pass anything in
			
			//need to create service registry to allow all the services hibernate is going to use to give us its crud functionality
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return config.buildSessionFactory(serviceRegistry);
			
		}catch(Throwable t) {
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
