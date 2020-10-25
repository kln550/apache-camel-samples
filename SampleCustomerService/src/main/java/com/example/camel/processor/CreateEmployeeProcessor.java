package com.example.camel.processor;

import com.example.camel.model.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class CreateEmployeeProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
    	Employee emp = new Employee();
		emp.setName("camel-employee");
		emp.setDesignation("camel-manager");
		emp.setEmpId(111);
		emp.setSalary(30000);
		exchange.getIn().setBody(emp);
    }

}