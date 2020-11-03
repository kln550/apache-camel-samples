package com.example.camel.kafka.config;

public class AddressInBound {
    private String brokers = "localhost:9092";

    public String getUri() {
        return "kafka:edit-inbound" +
                "?brokers=" + brokers;
    }
}

