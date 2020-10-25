package com.example.camel.kafka.config;

public class OutBoundProperties {
  private String brokers = "localhost:9092";
  private String topic = "outbound";
  private String serializerClass = "org.apache.kafka.common.serialization.ByteArraySerializer";
  private String keySerializerClass = "org.apache.kafka.common.serialization.StringSerializer";

  public String getUri() {
    return "kafka:outbound" +
            "?brokers=" + brokers +
            "&serializerClass=" + serializerClass +
            "&keySerializerClass=" + keySerializerClass;
  }
}