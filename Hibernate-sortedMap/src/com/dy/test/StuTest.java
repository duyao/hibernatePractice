package com.dy.test;


import java.util.TreeMap;

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

		TreeMap<String, Certificate> set1 = new TreeMap<String, Certificate>();
		set1.put("ComputerScience", new Certificate("MCA"));
		set1.put("BusinessManagement", new Certificate("MBA"));
		set1.put("ProjectManagement", new Certificate("PMP"));

		/* Add employee records in the database */
		Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);

		/* Another set of certificates for the second employee */
		TreeMap<String, Certificate> set2 = new TreeMap<String, Certificate>();
		set2.put("ComputerScience", new Certificate("MCA"));
		set2.put("BusinessManagement", new Certificate("MBA"));

		/* Add another employee record in the database */
		Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);

		/* List down all the employees */
		ME.listEmployees();

		/* Update employee's salary records */
		ME.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		ME.deleteEmployee(empID2);

		/* List down all the employees */
		ME.listEmployees();

	}

}
