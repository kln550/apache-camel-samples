package com.example.camel.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetails(@PathVariable String id) {
		return new EmployeeDetails(id, "Test Employee1");
	}

}
