package com.example.camel.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeAddressController {

	@RequestMapping(value = "/employees/{id}/address", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetails(@PathVariable String id) {
		return new EmployeeDetails(id, "Stree1, city-1, MA, USA, 11111");
	}

}
