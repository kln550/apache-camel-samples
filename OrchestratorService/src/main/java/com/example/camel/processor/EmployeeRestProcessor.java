package com.example.camel.processor;

import com.example.camel.controller.EmployeeDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;

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