package com.example.camel.route;

import com.example.camel.processor.ConsumerBean;
import com.example.camel.kafka.config.InBoundProperties;
import com.example.camel.kafka.config.OutBoundProperties;
import com.example.camel.processor.MyProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.model.rest.RestBindingMode;
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
        // configures REST DSL to use servlet component and in JSON mode
        // This section is required - it tells Camel how to configure the REST service
        restConfiguration().host("localhost").port(8080)
                // Use the 'servlet' component.
                // This tells Camel to create and use a Servlet to 'host' the RESTful API.
                // Since we're using Spring Boot, the default servlet container is Tomcat.
                .component("servlet")
                // Allow Camel to try to marshal/unmarshal between Java objects and JSON
                .bindingMode(RestBindingMode.auto);

        // Kafka Producer
        from("file:src/data?noop=true")
                .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
                .to(new InBoundProperties().getUri());

        from(new InBoundProperties().getUri())
                .log("Message received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .setHeader("id", simple("${random(1,2)}"));
                 //.to("rest:get:/employees/{id}").log("${body}");
                //.to("http://localhost:8080/employees/1").process(new MyProcessor());

        //rest("/employees/1").get().to(new OutBoundProperties().getUri());
                //get("/{id}").to("direct:customerDetail")
                //.get("/{id}/orders").to("direct:customerOrders")
                //.post("/neworder").to("direct:customerNewOrder");

        //from("file:src/data2?noop=true")
        //        .setHeader(KafkaConstants.KEY, constant("Camel")) // Key of the message
        //        .to(new OutBoundProperties().getUri());

        //from(new OutBoundProperties().getUri())
        //        .log("Message received from Kafka : ${body}")
        //        .log("    on the topic ${headers[kafka.TOPIC]}")
        //        .log("    on the partition ${headers[kafka.PARTITION]}")
        ////        .log("    with the offset ${headers[kafka.OFFSET]}")
        //        .log("    with the key ${headers[kafka.KEY]}").bean(ConsumerBean.class, "consume");
    }
}