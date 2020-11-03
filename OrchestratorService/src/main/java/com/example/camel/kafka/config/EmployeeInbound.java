package com.example.camel.kafka.config;

public class EmployeeInbound {
    private String brokers = "localhost:9092";
    private String topic = "inbound";

    public String getUri() {
        return "kafka:inbound" +
                "?brokers=" + brokers;
    }
}