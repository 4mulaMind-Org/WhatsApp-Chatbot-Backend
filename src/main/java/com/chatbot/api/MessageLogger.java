package com.chatbot.api;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageLogger — Logs all incoming messages
 *
 * Single Responsibility: Only handles logging
 *
 * Stores logs in memory + prints to console
 */
@Service
public class MessageLogger {

    private final List<String> logs = new ArrayList<>();
    private final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Logs an incoming message with timestamp
     */
    public void log(WhatsAppMessage msg, String reply) {
        String timestamp = LocalDateTime.now().format(formatter);
        String entry = String.format("[%s] FROM: %s | MSG: %s | REPLY: %s",
            timestamp, msg.getFrom(), msg.getMessage(), reply);

        logs.add(entry);
        System.out.println("[LOG] " + entry);
    }

    /**
     * Returns all logged messages (for /logs endpoint)
     */
    public List<String> getAllLogs() {
        return new ArrayList<>(logs);
    }

    /**
     * Returns total message count
     */
    public int getTotalMessages() {
        return logs.size();
    }
}
