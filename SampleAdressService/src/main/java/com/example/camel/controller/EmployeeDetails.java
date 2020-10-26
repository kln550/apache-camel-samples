package com.example.camel.controller;

public class EmployeeDetails {
	private String id;
	private String address;

	public EmployeeDetails() {
	}

	public EmployeeDetails(String id, String address) {
		this.id = id;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return address;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.address = name;
	}

	@Override
	public String toString() {
		return "EmployeeDetails[GET]{" +
				"id='" + id + '\'' +
				", name='" + address + '\'' +
				'}';
	}
}
