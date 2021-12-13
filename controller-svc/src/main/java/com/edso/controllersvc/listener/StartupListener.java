package com.edso.controllersvc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {
    @KafkaListener(topics = "demo1", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Topic demo1: get " + message + "from kafka");

    }
}
