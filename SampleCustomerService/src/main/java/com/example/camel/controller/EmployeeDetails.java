package com.example.camel.controller;

public class EmployeeDetails {
	private String id;
	private String name;

	public EmployeeDetails() {
	}

	public EmployeeDetails(String id, String name) {
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "EmployeeDetails[GET]{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
