package manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onetomany.AnswerM;
import com.onetomany.Question1;
import com.onetoone.Answer;
import com.onetoone.Question;

public class App4 {
	public static void main(String arg[]) {
		
		 Configuration cfg = new Configuration();
	    	cfg.configure();
	    	
	    	SessionFactory sf = cfg.buildSessionFactory();
	    	Session sess = sf.openSession();
	    	
	    	QuestionM q1 = new QuestionM();
	    	q1.setQid(101);
	    	q1.setQuestion("What is local variable?");
	    	
	    	QuestionM q2 = new QuestionM();
	    	q2.setQid(102);
	    	q2.setQuestion("What is size of boolean variable?");
	    	
	    	QuestionM q3 = new QuestionM();
	    	q3.setQid(103);
	    	q3.setQuestion("List Java IDE's.");
	    	
	    	Answer2 a1 = new Answer2();
	    	a1.setAid(01);
	    	a1.setAnswer("Variable defined inside method.");
	    	
	    	Answer2 a2 = new Answer2();
	    	a2.setAid(02);
	    	a2.setAnswer("16-bit.");
	    	
	    	Answer2 a3 = new Answer2();
	    	a3.setAid(03);
	    	a3.setAnswer("Eclipse and Netbeans.");
	    	
	    	List<QuestionM> li1 = new ArrayList<QuestionM>();
	    	li1.add(q1);
	    	li1.add(q2);
	    	li1.add(q3);
	    	
	    	List<Answer2> li2 = new ArrayList<Answer2>();
	    	li2.add(a1);
	    	li2.add(a2);
	    	li2.add(a3);
	    	
	    	
	    	for(Answer2 a:li2) {
	    		a.setQue(li1);
	    	}
	    	for(QuestionM q:li1) {
	    		q.setAns(li2);
	    	}
	    	
	    	Transaction tx = sess.beginTransaction();
	    	sess.save(q1);
	    	sess.save(q2);
	    	sess.save(q3);
	    	
	    	tx.commit();
	    	sess.close();
	    	System.out.println( "Successfull!" );
	}

}
