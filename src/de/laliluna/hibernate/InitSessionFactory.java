package de.laliluna.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InitSessionFactory {
	/** The single instance of hibernate SessionFactory */
	private static SessionFactory sessionFactory;
	
	private InitSessionFactory() {}
	
	static {
		final Configuration config = new Configuration();
		config.configure("/hibernate.cfg.xml");
		sessionFactory = config.buildSessionFactory();
	}
	
	public static SessionFactory getInstance() {
		return sessionFactory;
	}
	
}
