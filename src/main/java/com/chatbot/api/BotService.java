package com.chatbot.api;

import org.springframework.stereotype.Service;

/**
 * BotService — Handles reply logic for incoming messages
 *
 * Single Responsibility: Only decides what reply to give
 *
 * Rules:
 *   Hi       → Hello
 *   Bye      → Goodbye
 *   Help     → Available commands: Hi, Bye, Help, About
 *   About    → I am a WhatsApp Chatbot built with Java Spring Boot
 *   (others) → Sorry, I did not understand that.
 */
@Service
public class BotService {

    public String getReply(String message) {

        if (message == null || message.isBlank()) {
            return "Please send a valid message.";
        }

        // Normalize — trim whitespace and lowercase for comparison
        String normalized = message.trim().toLowerCase();

        return switch (normalized) {
            case "hi", "hello", "hey"   -> "Hello! How can I help you today?";
            case "bye", "goodbye"       -> "Goodbye! Have a great day!";
            case "help"                 -> "Available commands: Hi, Bye, Help, About";
            case "about"                -> "I am a WhatsApp Chatbot Backend built with Java Spring Boot by Abdul Qadir.";
            default                     -> "Sorry, I did not understand that. Type 'Help' to see available commands.";
        };
    }
}
