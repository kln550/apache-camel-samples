package com.example.camel.routes;

import com.example.camel.kafka.config.AddressInBound;
import com.example.camel.kafka.config.AddressOutBound;
import com.example.camel.processor.AddressRestResponseProcessor;
import com.example.camel.processor.EmployeeIdProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class AddressGetRouteBuilder extends RouteBuilder {
    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() throws Exception {
        // 1. Kafka inbound topic consumer
        // 2. Parse and get employee id.
        // 3. Pass id to employee REST API get
        // 4. Publish employee response to outbound topic.
        from(new AddressInBound().getUri())
                .log("\n*** Message received from Kafka address[inbound]")
                .log("\n*** on the topic ${headers[kafka.TOPIC]}")
                .process(new EmployeeIdProcessor())
                .log("\nEmployee id from Kafka topic ${id} ${headers[emp_id]}")
                .setHeader(Exchange.HTTP_METHOD, simple("GET"))
                .to("http://localhost:8090/emp-address/65382")
                .log("\nBody after address GET ${body}")
                .process(exchange -> {
                    InputStream in = exchange.getIn().getBody(InputStream.class);
                    in.reset();
                }).process(new AddressRestResponseProcessor())
                .to(new AddressOutBound().getUri());
    }
}