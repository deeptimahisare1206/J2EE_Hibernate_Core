package com.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Insert {
	public static void main(String[] args) {
		
		  Configuration cfg = new Configuration();
	    	cfg.configure();
	    	
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session sess = sf.openSession();
	    	
		Patient p = new Patient();
		p.setPid(4);
		p.setName("Prince");
		p.setRno(104);
		
		Transaction tx = sess.beginTransaction();
    	sess.save(p);
    	tx.commit();
    	sess.close();
		System.out.println("Registered Success!!");
		
	}

}
