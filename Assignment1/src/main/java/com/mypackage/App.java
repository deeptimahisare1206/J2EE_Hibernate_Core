package com.mypackage;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration();
    	cfg.configure();
    	
    	SessionFactory sf = cfg.buildSessionFactory();
    	Session sess = sf.openSession();
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Choose any:");
        System.out.println( "Enter 1 to insert data." );
        System.out.println( "Enter 2 to select data." );
        System.out.println( "Enter 3 to update data." );
        System.out.println( "Enter 4 to delete data." );
        int n = sc.nextInt();
        Student st;
        switch (n) {
		case 1:
			System.out.println("Insertion.");
			System.out.print("Enter roll no.:");
			int r = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter name:");
			String nm = sc.nextLine();
			System.out.print("Enter percentage:");
			double p = sc.nextDouble();
			
			st = new Student();
			st.setRoll(r);
			st.setName(nm);
			st.setPercent(p);
			
			Transaction tx = sess.beginTransaction();
	    	sess.save(st);
	    	tx.commit();
	    	sess.close();
			System.out.println("Registered Success!!");
			break;
			
		case 2:
			System.out.println("Selection.");
			System.out.print("Enter roll no.:");
			int rl = sc.nextInt();
			st = (Student)sess.get(Student.class, rl);
	    	
		System.out.println("Student Id = " + st.getRoll());
		System.out.println("Student Name = " + st.getName());
		System.out.println("Student Pertage = " + st.getPercent());
			break;
		case 3:
			System.out.println("Updation.");
			System.out.print("Enter roll no.:");
			int rn = sc.nextInt();
			Student st1 =(Student)sess.get(Student.class, rn);
			System.out.println( "Enter 1 to update name." );
	        System.out.println( "Enter 2 to update percent." );
	        int n1 = sc.nextInt();
	        
	        if(n1==1) {
	        	System.out.print("Name: ");
	        	sc.nextLine();
	        	String un = sc.nextLine();
	        	st1.setName(un);

	        	tx = sess.beginTransaction();
		    	sess.update(st1);
		    	tx.commit();
	        }
	        else {
	        	System.out.print("Percent: ");
	        	double per = sc.nextDouble();
	        	st1.setPercent(per);

	        	tx = sess.beginTransaction();
		    	sess.update(st1);
		    	tx.commit();
	        }
	    	
			break;
		case 4:
			System.out.println("Deletion.");
			System.out.print("Enter roll no.:");
			int roll = sc.nextInt();
			
			st = new Student();
			st.setRoll(roll);
			tx = sess.beginTransaction();
	    	sess.delete(st);
	    	tx.commit();
			break;
		default:
			System.out.println("default");
			break;
		}
sess.close();
        
    }
}
