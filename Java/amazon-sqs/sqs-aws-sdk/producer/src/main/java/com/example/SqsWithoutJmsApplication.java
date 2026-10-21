package com.example;

import com.example.services.SqsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SqsWithoutJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SqsWithoutJmsApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(SqsService sqsService) {
        return args -> {
            sqsService.sendMessage("Hello, this is a test message!");
        };
    }
}
