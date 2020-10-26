package com.example.camel.kafka.config;

public class AddressOutBound {
  private String brokers = "localhost:9092";
  private String topic = "outbound";
  private String serializerClass = "org.apache.kafka.common.serialization.ByteArraySerializer";
  private String keySerializerClass = "org.apache.kafka.common.serialization.ByteArraySerializer";

  public String getUri() {
    return "kafka:edit-outbound" +
            "?brokers=" + brokers +
            "&serializerClass=" + serializerClass +
            "&keySerializerClass=" + keySerializerClass;
  }
}