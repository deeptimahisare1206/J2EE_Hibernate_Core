package com.mypackage;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Select {
	
	public static void main(String[] args) {
		
		  Configuration cfg = new Configuration();
	    	cfg.configure();
	    	
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session sess = sf.openSession();
	    	
	    	Patient p =(Patient)sess.get(Patient.class, 4);
	    	
	    	sess.close();
		System.out.println("Patient Id = " + p.getPid());
		System.out.println("Patient name = " + p.getName());
		System.out.println("Patient Room no = " + p.getRno());
	}

}
