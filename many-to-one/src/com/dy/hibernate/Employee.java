package com.dy.hibernate;


//if address is component,then implements java.io.Serializable,and add <component> label in hbm.xml
public class Employee /*implements java.io.Serializable*/{
	private int id;
	private String firstName;
	private String lastName;
	private int salary;
	private Address address;
	
	public Employee() {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	public Employee(String firstName, String lastName, int salary,
			Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.address = address;
	}

	
	

	
}