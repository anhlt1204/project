package com.edso.matchingengine.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupListener{
    @KafkaListener(topics = "demo", groupId = "group-id")
    public void listen(String message) {
        log.info("Topic demo: get " + message + " from kafka");
        sendMessage(message);
        log.info("--> Topic demo1: send " + message + " to kafka");
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("demo1", msg);
    }
}
