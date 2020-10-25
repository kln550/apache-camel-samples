package com.example.camel.kafka.config;

public class InBoundProperties {
    private String brokers = "localhost:9092";
    private String topic = "outbound";
    private String serializerClass = "org.apache.kafka.common.serialization.StringSerializer";
    private String keySerializerClass = "org.apache.kafka.common.serialization.StringSerializer";

    public String getUri() {
        return "kafka:inbound" +
                "?brokers=" + brokers +
                "&serializerClass=" + serializerClass +
                "&keySerializerClass=" + keySerializerClass;
    }
}