package com.example.camel.controller;

public class EmployeeDetails {
	private String id;
	private String address;
	private String firstName;
	private String lastName;
	private String name;

	public EmployeeDetails() {
	}

	public EmployeeDetails(String id, String address) {
		this.id = id;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [id=" + id + ", address=" + address + ", firstName=" + firstName + ", lastName="
				+ lastName + ", name=" + name + "]";
	}

}
