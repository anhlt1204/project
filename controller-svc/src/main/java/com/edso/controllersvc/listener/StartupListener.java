package com.edso.controllersvc.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {
    @KafkaListener(topics = "demo1", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Topic demo1: get " + message + "from kafka");
        sendMessage(message);
        System.out.println("Topic demo2: send " + message + " to kafka");
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send("demo2", msg);
    }
}
