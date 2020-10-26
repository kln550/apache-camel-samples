package com.example.camel.kafka.convertors;

import com.example.camel.controller.EmployeeDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmployeeTypeConverter implements TypeConverters {

    private final ObjectMapper mapper;

    @Autowired
    public EmployeeTypeConverter(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Converter
    public String employeeToString(EmployeeDetails source) {
        try {
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Converter
    public EmployeeDetails strToEmployee(String source) {
        try {
            return mapper.readValue(source, EmployeeDetails.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}