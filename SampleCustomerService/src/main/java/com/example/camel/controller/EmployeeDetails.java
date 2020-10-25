package com.example.camel.controller;

public class EmployeeDetails {

	private final String id;
	private final String name;

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
}
