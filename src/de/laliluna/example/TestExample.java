package de.laliluna.example;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import de.laliluna.hibernate.InitSessionFactory;
import javassist.bytecode.Descriptor.Iterator;

public class TestExample {
	
	private static Logger log = Logger.getLogger(TestExample.class);
	
	public static void main(String[] args) {
		
		//clean tables:
		clean();
		
		//simple create example:
		createHoney();
		
		//relation example:
		createRelation();
		
		//delete example:
		delete();
		
		//update example:
		update();
		
		//query example:
		query();
		
	}

	private static Honey createHoney() {
		Honey forestHoney = new Honey("forest honey", "very sweet");
		
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.save(forestHoney);
		tx.commit();
		session.close();
		
		return forestHoney;
	}
	
	private static void update() {
		Honey honey = createHoney();
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		honey.setName("Modern style");
		session.update(honey);
		tx.commit();
		session.close();
	}
	
	private static void delete() {
		Honey honey = createHoney();
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(honey);
		tx.commit();
		session.close();
	}
	
	private static void clean() {
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete from Bee").executeUpdate();
		session.createQuery("delete from Honey").executeUpdate();
		tx.commit();
		session.close();
	}
	
	private static void createRelation() {
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		Honey honey = new Honey("country honey", "delicious");
		session.save(honey);
		Bee bee = new Bee("Sebastian");
		session.save(bee);
		
		bee.setHoney(honey);
		honey.getBees().add(bee);
		
		tx.commit();
		session.close();
	}
	
	private static void query() {
		Session session = InitSessionFactory.getInstance().openSession();
		Transaction tx = session.beginTransaction();
		List<Honey> honeys = session.createQuery("SELECT h FROM honey AS h").getResultList();
		for ( java.util.Iterator<Honey> iter = honeys.iterator(); iter.hasNext(); ) {
			Honey h = (Honey) iter.next();
			log.debug(h);
		}
		
		tx.commit();
		session.close();
	}

}
