package com.example.camel.kafka.config;

public class EmployeeOutBound {
  private String brokers = "localhost:9092";
  private String topic = "outbound";

  public String getUri() {
    return "kafka:outbound" +
            "?brokers=" + brokers;
  }
}