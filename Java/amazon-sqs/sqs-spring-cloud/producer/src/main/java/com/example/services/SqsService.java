package com.example.services;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsService {
    @SqsListener("test-queue")
    public void pollMessages(String message) {
        System.out.println("Received message: " + message);
    }
}
