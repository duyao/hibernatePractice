package com.dy.hibernate.sortedSet;

import java.util.SortedSet;
import java.util.TreeSet;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	private SortedSet<Certificate> certificates = new TreeSet<Certificate>();
	
	public Employee() {
	}

	public Employee(String fname, String lname, int salary) {
		this.firstName = fname;
		this.lastName = lname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	//set mapping
    public SortedSet<Certificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(SortedSet<Certificate> certificates) {
		this.certificates = certificates;
	}

	
	

	
}