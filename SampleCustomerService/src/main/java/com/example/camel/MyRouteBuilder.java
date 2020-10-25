package com.example.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

/**
 * A Camel Java DSL Router
 */
@Component
public class MyRouteBuilder extends RouteBuilder {
    /**
     * Let's configure the Camel routing rules using Java code...
     */
    @Override
    public void configure() throws Exception {
        // Kafka Producer
        from("file:src/data?noop=true")
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to(new InBoundProperties().getUri());

        from(new InBoundProperties().getUri())
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}").bean(ConsumerBean.class, "consume")
                .to("file:src/data2");

        from("file:src/data2?noop=true")
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to(new OutBoundProperties().getUri());

        from(new OutBoundProperties().getUri())
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}").bean(ConsumerBean.class, "consume");
    }
}