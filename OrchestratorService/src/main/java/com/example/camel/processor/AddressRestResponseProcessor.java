package com.example.camel.processor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class AddressRestResponseProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String employeeDetails = exchange.getIn().getBody(String.class);
        System.out.println("**** sending to Outbound topic ***** " + employeeDetails);
        Object empDetails = exchange.getIn().getHeader("emp_details");
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