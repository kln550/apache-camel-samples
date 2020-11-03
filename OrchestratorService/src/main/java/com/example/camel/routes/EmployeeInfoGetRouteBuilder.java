package com.example.camel.routes;

import com.example.camel.kafka.config.EmployeeInbound;
import com.example.camel.kafka.config.EmployeeOutBound;
import com.example.camel.processor.EmployeeIdProcessor;
import com.example.camel.processor.EmployeeRestProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * A Camel Java DSL Router
 */
@Component
public class EmployeeInfoGetRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // 1. Kafka inbound topic consumer
        // 2. Parse and get employee id.
        // 3. Pass id to employee REST API get
        // 4. Publish employee response to outbound topic.
       from(new EmployeeInbound().getUri())
                .log("\n*** Message received from Kafka : ${body}")
                .log("\n*** on the topic ${headers[kafka.TOPIC]}")
                .process(new EmployeeIdProcessor())
                .log("\nEmployee id from Kafka topic ${id} employee id ${headers[emp_id]}")
               .setHeader(Exchange.HTTP_METHOD, simple("GET"))
               .to("http://localhost:8080/employees/12345")
               .log("\nBody after address GET ${body} ${headers[emp_id]}")
               .process(exchange -> {
                   InputStream in = exchange.getIn().getBody(InputStream.class);
                   in.reset();
               })
               .process(new EmployeeRestProcessor())
               .to(new EmployeeOutBound().getUri());
    }
}