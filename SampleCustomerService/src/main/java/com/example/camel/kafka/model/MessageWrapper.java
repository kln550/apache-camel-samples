package com.example.camel.kafka.model;

import java.io.Serializable;

public class MessageWrapper implements  Serializable {

    private static final long serialVersionUID = 2121211L;

    private long timestamp;
    private String callerModule;
    private MessageType messageType;
    private String payload;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCallerModule() {
        return callerModule;
    }

    public void setCallerModule(String callerModule) {
        this.callerModule = callerModule;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}