package com.dy.test;

import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dy.hibernate.Certificate;
import com.dy.hibernate.ManageEmployee;

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
		// 手动关闭，创建新对象
		session = sessionFactory.openSession();
		// 要cfg中配置，自动关闭，使用现有对象
		// session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();

		ME = new ManageEmployee();
		ME.setSession(session);

	}

	@After
	public void destory() {
		// 不会自动提交
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void test() {


		
		
		/* Let us have a set of certificates for the first employee */
		HashMap<String, Certificate> set = new HashMap<String, Certificate>();
		set.put("ComputerScience", new Certificate("MCA"));
		set.put("BusinessManagement", new Certificate("MBA"));
		set.put("ProjectManagement", new Certificate("PMP"));

		Integer empID = ME.addEmployee("Manoj", "Kumar", 4000, set);
		ME.listEmployees();

		ME.updateEmployee(empID, 5000);
		ME.listEmployees();

	}

}
