package com.example;

import com.example.services.SqsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqsSpringCloudApplication {
    public static void main(String[] args) {
        SpringApplication.run(SqsSpringCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(SqsService sqsService) {
        return args -> {
            sqsService.sendMessage("Hello, SQS!");
        };
    }
}
