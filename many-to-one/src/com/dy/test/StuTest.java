package com.dy.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dy.hibernate.Address;
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
		 /* Let us have one address object */
	      Address address1 = ME.addAddress("Kondapur","Hyderabad","AP","532");

	      /* Add employee records in the database */
	      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, address1);

	      /* Let us have another address object */
	      Address address2 = ME.addAddress("Saharanpur","Ambehta","UP","111");
	  
	    /* Add another employee record in the database */
	      Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, address2);

	      /* List down all the employees */
	      ME.listEmployees();

	      /* Update employee's salary records */
	      ME.updateEmployee(empID1, 5000);

	      /* List down all the employees */
	      ME.listEmployees();
	}

}
