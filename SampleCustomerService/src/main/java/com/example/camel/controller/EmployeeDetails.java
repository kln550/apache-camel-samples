package com.example.camel.controller;

public class EmployeeDetails {
	private String id;
	private String name;
	private String firstName;
	private String lastName;

	public EmployeeDetails() {
	}

	public EmployeeDetails(String id, String name, String firstName, String lastName) {
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

	

}
