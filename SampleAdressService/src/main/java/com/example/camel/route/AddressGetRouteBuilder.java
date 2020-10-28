package com.example.camel.route;

import java.io.InputStream;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import com.example.camel.kafka.config.InBoundProperties;
import com.example.camel.kafka.config.OutBoundProperties;
import com.example.camel.processor.EmployeeIdProcessor;
import com.example.camel.processor.EmployeeRestProcessor;

/**
 * A Camel Java DSL Router
 */
@Component
public class AddressGetRouteBuilder extends RouteBuilder {
    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() throws Exception {
        restConfiguration().host("localhost").port(8090).component("servlet").bindingMode(RestBindingMode.json);

        // 1. Kafka inbound topic consumer
        // 2. Parse and get employee id.
        // 3. Pass id to employee REST API get
        // 4. Publish employee response to outbound topic.
        from(new InBoundProperties().getUri())
                .log("\n*** Message received from Kafka : ${body}")
                .log("\n*** on the topic ${headers[kafka.TOPIC]}")
                .process(new EmployeeIdProcessor())
                .log("\nEmployee id from Kafka topic ${id}")
                .to("rest:get:employees/{id}/address")
                .log("\nBody after employee GET ${body}")
                .process(exchange -> {
                    InputStream in = exchange.getIn().getBody(InputStream.class);
                    in.reset();
                }).process(new EmployeeRestProcessor())
                .to(new OutBoundProperties().getUri());

    }
}