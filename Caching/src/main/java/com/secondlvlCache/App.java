package com.secondlvlCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  
    	
    	
    	 Configuration cfg = new Configuration();
	    	cfg.configure();
	    	
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session sess = sf.openSession();
//	    	
//	    	Library p = new Library();
//			p.setBid(2);
//			p.setBname("Hibernate");
//			
//			Transaction tx = sess.beginTransaction();
//	    	sess.save(p);
//	    	tx.commit();
	    	
	    	Library l1 =(Library)sess.get(Library.class, 1);
	    	
		System.out.println("->  " + l1.getBid() + "    " +l1.getBname());
		sess.close();
		
		
		Session sess2 = sf.openSession();
		Library l2 =(Library)sess2.get(Library.class, 1);
    	
		System.out.println("->  " + l2.getBid() + "    " +l2.getBname());
		sess2.close();
    }
}
