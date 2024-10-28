package com.mypackage;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Delete {
	
	public static void main(String[] args) {
		  Configuration cfg = new Configuration();
	    	cfg.configure();
	    	
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session sess = sf.openSession();
	    	
	    	Patient p = new Patient();
	    	p.setPid(3);
	    	
	    	Transaction tx = sess.beginTransaction();
	    	sess.delete(p);
	    	tx.commit();
	    	sess.close();
	    	System.out.println("Delete success!!");
		
	}

}
