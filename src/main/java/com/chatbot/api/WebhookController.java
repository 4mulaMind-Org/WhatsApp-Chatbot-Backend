package com.chatbot.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WebhookController — REST API for WhatsApp chatbot webhook
 *
 * Endpoints:
 *   POST /webhook       → Receive WhatsApp message, return reply
 *   GET  /logs          → View all message logs
 *   GET  /health        → Health check
 */
@RestController
public class WebhookController {

    @Autowired
    private BotService botService;

    @Autowired
    private MessageLogger messageLogger;

    /**
     * POST /webhook
     * Receives simulated WhatsApp message and returns bot reply
     *
     * Request Body:
     * {
     *   "from": "919876543210",
     *   "message": "Hi"
     * }
     *
     * Response:
     * {
     *   "to": "919876543210",
     *   "reply": "Hello! How can I help you today?"
     * }
     */
    @PostMapping("/webhook")
    public ResponseEntity<ChatbotResponse> handleWebhook(
            @RequestBody WhatsAppMessage incomingMessage) {

        // Validate input
        if (incomingMessage.getFrom() == null || incomingMessage.getMessage() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Get bot reply
        String reply = botService.getReply(incomingMessage.getMessage());

        // Log the message
        messageLogger.log(incomingMessage, reply);

        // Return response
        ChatbotResponse response = new ChatbotResponse(incomingMessage.getFrom(), reply);
        return ResponseEntity.ok(response);
    }

    /**
     * GET /logs
     * Returns all logged messages and total count
     */
    @GetMapping("/logs")
    public ResponseEntity<Map<String, Object>> getLogs() {
        List<String> logs = messageLogger.getAllLogs();

        Map<String, Object> response = new HashMap<>();
        response.put("totalMessages", messageLogger.getTotalMessages());
        response.put("logs", logs);

        return ResponseEntity.ok(response);
    }

    /**
     * GET /health
     * Health check endpoint for deployment verification
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "WhatsApp Chatbot Backend");
        response.put("developer", "Abdul Qadir");
        return ResponseEntity.ok(response);
    }
}
