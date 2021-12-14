package com.edso.controllersvc.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupListener {
    @KafkaListener(topics = "demo1", groupId = "group-id")
    public void listen(String message) {
        log.info("Topic demo1: get " + message + "from kafka");
        sendMessage(message);
        log.info("Topic demo2: send " + message + " to kafka");
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("demo2", msg);
    }
}
