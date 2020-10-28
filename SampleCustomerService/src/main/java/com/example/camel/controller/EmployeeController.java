package com.example.camel.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetails(@PathVariable String id) {
		return new EmployeeDetails(id, "Test Employee1", "John", "Smith");
	}

}
