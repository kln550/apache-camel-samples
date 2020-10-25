package com.example.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource({"classpath:camel-context.xml"})
public class SpringBootCamelKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCamelKafkaApplication.class, args);
    }

}


