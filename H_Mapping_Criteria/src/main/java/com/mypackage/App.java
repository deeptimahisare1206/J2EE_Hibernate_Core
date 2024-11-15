package com.mypackage;

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
    	
    	Doctor d = new Doctor();
    	d.setD_name("Dr.Shyam meena");
    	d.setProfession("Psysologist");
    	
    	Transaction tx =sess.beginTransaction();
    	sess.save(d);
    	tx.commit();
    	sess.close();
    	sf.close();
    }
}
