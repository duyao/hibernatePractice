package com.dy.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dy.hibernate.set.Certificate;
import com.dy.hibernate.set.ManageEmployee;


public class StuTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	private ManageEmployee ME;

	@Before
	public void init() {
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		sessionFactory = config.buildSessionFactory(serviceRegistry);
		// �ֶ��رգ������¶���
		session = sessionFactory.openSession();
		// Ҫcfg�����ã��Զ��رգ�ʹ�����ж���
		// session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();

		ME = new ManageEmployee();
		ME.setSession(session);

	}

	@After
	public void destory() {
		// �����Զ��ύ
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test() {
		Set set1 = new HashSet();
		set1.add(new Certificate("MCA"));
		set1.add(new Certificate("MBA"));
		set1.add(new Certificate("PMP"));
		Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);
		
		HashSet set2 = new HashSet();
		set2.add(new Certificate("BCA"));
		set2.add(new Certificate("BA"));
		Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);

		ME.listEmployees();

	}

}
