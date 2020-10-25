package com.example.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

/**
 * A Camel route that calls the REST service using a timer
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class SampleRestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // call the embedded rest service from the PetController
        //restConfiguration().host("localhost").port(8080).component("servlet").bindingMode(RestBindingMode.json);

       // from("timer:hello?period=20000")
       //         .setHeader("id", simple("${random(1,3)}"))
       //         .to("rest:get:employees/{id}")
       //        .log("${body}");
    }

}