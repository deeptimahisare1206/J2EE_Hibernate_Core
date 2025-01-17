package com.mycompany;

import java.io.FileInputStream;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	try{
        	
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session sess = sf.openSession();
    	
    	Student s = new Student();
    	s.setRoll(103);
    	s.setName("Mickey");
    	s.setPercent(95.0);
    	s.setX(100);
    	s.setRoll(121);
    	s.setDate(new Date());
    	s.setOpen(false);
    	
//    	
    	FileInputStream fis = new FileInputStream("src/main/java/MickeyMouse.jpg");
    	byte b[] = new byte[fis.available()];
    	fis.read(b);
    	s.setImage(b);
    	
    	Transaction tx = sess.beginTransaction();
    	sess.save(s);
    	tx.commit();
    	sess.close();
    	
    	System.out.println("Done");
        } catch(Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}
