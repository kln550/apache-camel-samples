package com.example.camel.processor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.IOException;

public class EmployeeRestProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String employeeDetails = exchange.getIn().getBody(String.class);
        System.out.println("**** Body before before sending to Outbound topic ***** " + employeeDetails);
        exchange.getIn().setHeader("emp_details",  strToEmployee(employeeDetails));
        exchange.getIn().setBody(employeeDetails);
    }

    @Converter
    public String employeeToString(EmployeeDetails source) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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