package com.example.camel.processor;

import com.example.camel.controller.EmployeeDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmployeeIdProcessor implements Processor {
    ObjectMapper mapper = new ObjectMapper();

    public void process(Exchange exchange) throws Exception {
         String employeeId  = exchange.getIn().getBody(String.class);
         EmployeeDetails employeeDetails = strToEmployee(employeeId);
         exchange.getIn().setHeader("id",  employeeDetails.getId());
         System.out.println("**** Employee id in processor ***** "+employeeDetails.getId());
    }

    public EmployeeDetails strToEmployee(String source) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(source, EmployeeDetails.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}