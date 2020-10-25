package com.example.camel.kafka.model;

/**
 * Type of payload exchanged through the Kafka topics
 */
public enum MessageType {

    STRING(String.class),
    ITEM(Employee.class);

    private final Class value;

    private MessageType(Class value) {
        this.value = value;
    }

    public Class value() {
        return value;
    }

    public static MessageType typeValue(Class v) {
        for (MessageType mt: MessageType.values()) {
            if (mt.value.equals(v)) {
                return mt;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }
}
