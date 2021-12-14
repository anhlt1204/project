package com.edso.wiserouter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SendController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private RedisTemplate template;

    public void sendMessage(String msg) {
        template.opsForValue().set("a", msg);
        template.convertAndSend("order", msg);
        log.info("Redis send message " + template.opsForValue().get("a"));
        kafkaTemplate.send("demo", msg);
        log.info("--> Topic demo: send " + msg + " to kafka");
    }

    @PostMapping
    public String send (@RequestParam String message) {
        sendMessage(message);
        return "ok";
    }
}
