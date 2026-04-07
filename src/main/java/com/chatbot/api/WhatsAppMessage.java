package com.chatbot.api;

/**
 * WhatsAppMessage — Data model for incoming webhook request
 *
 * JSON input format:
 * {
 *   "from": "919876543210",
 *   "message": "Hi"
 * }
 */
public class WhatsAppMessage {

    private String from;     // Sender's phone number
    private String message;  // Message text

    // Default constructor (required by Jackson for JSON parsing)
    public WhatsAppMessage() {}

    public WhatsAppMessage(String from, String message) {
        this.from = from;
        this.message = message;
    }

    public String getFrom()              { return from; }
    public void   setFrom(String from)   { this.from = from; }

    public String getMessage()                 { return message; }
    public void   setMessage(String message)   { this.message = message; }

    @Override
    public String toString() {
        return "WhatsAppMessage{from='" + from + "', message='" + message + "'}";
    }
}
