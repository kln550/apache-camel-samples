package com.example.camel.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeAddressController {

	@RequestMapping(value = "/employees/{id}/address", method = RequestMethod.GET)
	public EmployeeDetails getEmployeeDetails(@PathVariable String id) {
		return new EmployeeDetails(id, "Stree1, city-1, MA, USA, 11111");
	}

}
