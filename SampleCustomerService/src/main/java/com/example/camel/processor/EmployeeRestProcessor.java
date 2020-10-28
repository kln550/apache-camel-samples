package com.example.camel.processor;

import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.example.camel.controller.EmployeeDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmployeeRestProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String employeeDetails = exchange.getIn().getBody(String.class);
        System.out.println("**** Body before before sending to Outbound topic ***** " + employeeDetails);
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

}