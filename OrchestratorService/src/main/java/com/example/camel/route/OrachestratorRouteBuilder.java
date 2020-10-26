package com.example.camel.route;

import com.example.camel.kafka.config.AddressInBound;
import com.example.camel.kafka.config.AddressOutBound;
import com.example.camel.kafka.config.EmployeeInbound;
import com.example.camel.kafka.config.EmployeeOutBound;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * A Camel Java DSL Router
 */
@Component
public class OrachestratorRouteBuilder extends RouteBuilder {
    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() throws Exception {

        // Kafka Producer[Inbound].
        from("file:src/data?noop=true")
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to(new EmployeeInbound().getUri());

        // Kafka Consumer[Outbound].
        from(new EmployeeOutBound().getUri())
                .log("\n*** Message received from Kafka[Outbound] : ${body}")
                .log("\n*** on the topic ${headers[kafka.TOPIC]}").to("file:src/data-output?noop=true&fileName=employee-outbound.json")
                .to(new AddressInBound().getUri());

        from(new AddressOutBound().getUri())
                .log("\n*** Message received from Kafka[Outbound] : ${body}")
                .log("\n*** on the topic ${headers[kafka.TOPIC]}").to("file:src/data-output?noop=true&fileName=address-outbound.json");

    }
}