package com.edso.pusher.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {
    @KafkaListener(topics = "demo2", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Topic demo2: get " + message + " from kafka");
    }
}
