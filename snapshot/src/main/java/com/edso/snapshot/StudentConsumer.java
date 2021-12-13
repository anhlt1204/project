package com.edso.snapshot;

import org.springframework.stereotype.Component;

@Component
public class StudentConsumer {

    public void handleMessage(Object msg) {
        System.out.println("Message> " + msg.toString());
    }
}
