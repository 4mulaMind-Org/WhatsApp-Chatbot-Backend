package com.chatbot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WhatsApp Chatbot Backend — Entry Point
 * Starts the Spring Boot application on port 8080
 */
@SpringBootApplication
public class ChatbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatbotApplication.class, args);
        System.out.println("==========================================");
        System.out.println("  WhatsApp Chatbot Backend: ONLINE!      ");
        System.out.println("  Webhook: POST /webhook                  ");
        System.out.println("==========================================");
    }
}
