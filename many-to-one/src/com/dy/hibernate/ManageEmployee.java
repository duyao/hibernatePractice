package com.dy.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.hibernate.Session;

public class ManageEmployee {

	private Session session;

	public Address addAddress(String street, String city, 
            String state, String zipcode){
		Address address = new Address(street, city, state, zipcode);
		int addressId = (int) session.save(address);
		
		return address;
	}

	public Integer addEmployee(String fname, String lname, 
            int salary, Address address){
		Employee employee = new Employee(fname, lname, salary, address);
		int employId = (int) session.save(employee);
		return employId;
		
	}
	public void listEmployees() {
		List<Employee> employees = session.createQuery("FROM Employee").list();
		for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();) {
			Employee employee = (Employee) iterator1.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.print("  Last Name: " + employee.getLastName());
			System.out.println("  Salary: " + employee.getSalary());
			Address address = employee.getAddress();
			System.out.println(address.toString());
		}

	}

	/* Method to update salary for an employee */
	public void updateEmployee(Integer EmployeeID, int salary) {
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		employee.setSalary(salary);
		session.update(employee);

	}

	/* Method to delete an employee from the records */
	public void deleteEmployee(Integer EmployeeID) {
		Employee employee = (Employee) session.get(Employee.class, EmployeeID);
		session.delete(employee);

	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
