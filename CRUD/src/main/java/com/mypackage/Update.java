package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Update {

	public static void main(String[] args) {
			
			  Configuration cfg = new Configuration();
		    	cfg.configure();
		    	
		    	SessionFactory sf = cfg.buildSessionFactory();
		    	Session sess = sf.openSession();
		    	
		    	Patient p =(Patient)sess.get(Patient.class, 4);
		    	p.setName("Prince");
		    	
		    	Transaction tx = sess.beginTransaction();
		    	sess.update(p);
		    	tx.commit();
		    	
		    	
		    	sess.close();
	}
}
