package com.edso.pusher.listener;

import com.edso.pusher.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {

    private final SimpMessagingTemplate template;

    public StartupListener(SimpMessagingTemplate template) {
        this.template = template;
    }

    @KafkaListener(topics = "demo2", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Topic demo2: get " + message + " from kafka");
        this.template.convertAndSend("/chat/messages", new Message("server" ,message));
    }
}
