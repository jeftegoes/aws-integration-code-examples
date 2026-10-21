package com.example.services;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqsService {
    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String message) {
        sqsTemplate.send("test-queue", message);

        System.out.println("Sending message: " + message);
    }
}