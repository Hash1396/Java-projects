package com.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.pojo.Student;

public class Test {
	public void saveStudent() {

		Configuration cgf = new Configuration();
		cgf.configure("hibernate.cfg.xml");
		SessionFactory factory = cgf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		Student st = new Student();
		//st.setId(101);
		st.setName("shruti");
		st.setEmail("shruti.deshinge21@gmail.com");
		st.setMobile("9561574252");
	    session.save(st);
		t.commit();
		session.close();
		System.out.println("Successfully saved");
	}
  public static void main(String[] args) {
	  
	System.out.println("main");
	Test sc = new Test();
	sc.saveStudent();
}
}
