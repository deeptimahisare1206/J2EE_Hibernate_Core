package com.mypackage;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Add_Criteria {
	public static void main(String args[]) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session sess = sf.openSession();
		
		
		CriteriaBuilder cb = sess.getCriteriaBuilder();
		CriteriaQuery<Doctor> cq = cb.createQuery(Doctor.class);
		
		Root<Doctor> root = cq.from(Doctor.class);
		cq.select(root);
		
		Query<Doctor> q = sess.createQuery("from Doctor");
		
		List<Doctor> li = q.list();
		for (Doctor doc : li) {
			System.out.println("d_id- " +doc.getD_id() );
			System.out.println("d_Name- " +doc.getD_name() );
			System.out.println("Profession- " +doc.getProfession() );
			
		}
	}

}
