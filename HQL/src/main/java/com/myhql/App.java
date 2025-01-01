package com.myhql;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
    	
//    	Query<Faculty> q1 = sess.createQuery("from Faculty");  //select all
// __________________________________________________________________________________________________________________?
//    	Query<Faculty> q = sess.createQuery("from Faculty where name='Deepti'"); //select according to name
// __________________________________________________________________________________________________________________?


    	Scanner sc = new Scanner(System.in);
//    	System.out.println("Enter name for search:");
//    	String nm =sc.next();
//    	Query<Faculty> q = sess.createQuery("from Faculty where name=:name");  //select according to the input search
//    	q.setParameter("name",nm);
// __________________________________________________________________________________________________________________?
    	
//    	Min and Max;
//    	System.out.println("Enter Min and Max Values:  ");
//    	int min =sc.nextInt();
//    	int max = sc.nextInt();
// __________________________________________________________________________________________________________________?

//    	Query<Faculty> q = sess.createQuery("from Faculty where salary>=:minn and salary<=:maxx");  //select according to the input search
//    	q.setParameter("minn", min);
//    	q.setParameter("maxx", max);
// __________________________________________________________________________________________________________________?
//
    	Query<Faculty> q = sess.createQuery("from Faculty");// select info according to number 
    	q.setFirstResult(11);
    	q.setMaxResults(5);
    	
    	


		List<Faculty> li = q.list();
		
		for (Faculty std : li) {
			
			System.out.println("Faculty Id = " + std.getRoll());
			System.out.println("Faculty Name = " + std.getName());
			System.out.println("Faculty Salary = " + std.getSalary());
			System.out.println("=================================================================");
			
		}
		
// __________________________________________________________________________________________________________________?

    	//Full Query in Hibernate:
    	
//    	Query<Faculty> q = sess.createNativeQuery("insert into Faculty values(?,?,?)");
//    	q.setParameter(1, 21);
//    	q.setParameter(2, "Deepti");
//    	q.setParameter(3, 500000);
//    	
//    	Query<Faculty[]> q1 = sess.createNativeQuery("select * from Faculty");
//    	
//    	List<Faculty[]> li = q1.getResultList();
//    	for (Faculty[] fac : li) {
//			for (Faculty fct :fac) {
//				System.out.println("Faculty Id = " + fct.getRoll());
//				System.out.println("Faculty Name = " + fct.getName());
//				System.out.println("Faculty Salary = " + fct.getSalary());
//				System.out.println("=================================================================");
//				
//			}
//		}
// __________________________________________________________________________________________________________________?

//		Transaction tx = sess.beginTransaction();
//    	tx.commit();
//    	sess.save(q);
    	
		sess.close();
		sf.close();
		
		
    }
}
