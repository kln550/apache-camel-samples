package com.example.camel.kafka.service;

import java.util.Date;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.camel.kafka.model.MessageType;
import com.example.camel.kafka.model.MessageWrapper;

@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private ProducerTemplate producerTemplate;

    private MessageWrapper encapsulateMessage(String payload, Class payloadType) {
        Date timestamp = new Date();
        MessageType messageType = MessageType.typeValue(payloadType);
        MessageWrapper messageWrapper = new MessageWrapper();
        messageWrapper.setTimestamp(timestamp.getTime());
        messageWrapper.setMessageType(messageType);
        messageWrapper.setPayload(payload);
        return messageWrapper;
    }

    private String convertPayloadToJson(Object payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;
        try {
            json = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Cannot convert payload to json");
        }

        return json;
    }

    /**
     * Send payload to the endpointUri
     * @param endpointUri
     * @param payload
     */
    public void sendBody(String endpointUri, Object payload) {
        LOGGER.info("Publishing a message on {}", endpointUri);
        String payloadJson = convertPayloadToJson(payload);
        MessageWrapper body = encapsulateMessage(payloadJson, payload.getClass());
        producerTemplate.sendBody(endpointUri, body);
    }

    /**
     * Send payload to the endpointUri without converting
     * @param endpointUri
     * @param payload
     */
    public void send(String endpointUri, Object payload) {
        producerTemplate.sendBody(endpointUri, payload);
    }

}