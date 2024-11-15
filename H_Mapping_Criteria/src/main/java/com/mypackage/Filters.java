package com.mypackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Filters {

	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Doctor> cq = cb.createQuery(Doctor.class);
		
		Root<Doctor> root = cq.from(Doctor.class);
		cq.select(root);
		
		//Sort according to name Equals
//		Predicate pd = cb.equal(root.get("profession"), "Cardiologist");
//		cq.select(root).where(pd);
//		-----------------------------------------------------------------------------------------
		//Sort according to salary greater and lesser
//		Predicate pd = cb.gt(root.get("salary"), 20000);
//		cq.select(root).where(pd);
		
//		Predicate pd = cb.lt(root.get("salary"), 200000);
//		cq.select(root).where(pd);
//		------------------------------------------------------------------------------------------
		Predicate pp = cb.equal(root.get("profession"), "Cardiologist");
		Predicate ps = cb.gt(root.get("salary"), 20000);
		cq.select(root).where(cb.and(pp,ps));
		
		
		Query<Doctor> q = sess.createQuery(cq);
		
		List<Doctor> li = q.list();
		for (Doctor doc : li) {
			System.out.println("d_id- " +doc.getD_id() );
			System.out.println("d_Name- " +doc.getD_name() );
			System.out.println("Profession- " +doc.getProfession() );
			System.out.println("Saalary- " + doc.getSalary());
			
		}
	}
}
