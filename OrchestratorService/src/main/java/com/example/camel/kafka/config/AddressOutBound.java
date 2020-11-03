package com.example.camel.kafka.config;

public class AddressOutBound {
  private String brokers = "localhost:9092";
  private String topic = "outbound";

  public String getUri() {
    return "kafka:edit-outbound" +
            "?brokers=" + brokers;
  }
}