package com.dy.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dy.hibernate001.Student;

public class StudentTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init(){
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		//手动关闭，创建新对象
		session = sessionFactory.openSession();
		//要cfg中配置，自动关闭，使用现有对象
		//session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		
	}
	
	@After
	public void destory(){
		//不会自动提交
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test() {
		Student student = new Student(1,"dy","female",new Date(),"苏州");
		session.save(student);
		
		
	}

}
