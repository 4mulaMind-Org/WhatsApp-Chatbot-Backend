package com.chatbot.api;

/**
 * ChatbotResponse — Data model for outgoing response
 *
 * JSON output format:
 * {
 *   "to": "919876543210",
 *   "reply": "Hello"
 * }
 */
public class ChatbotResponse {

    private String to;     // Recipient's phone number
    private String reply;  // Bot's reply message

    public ChatbotResponse(String to, String reply) {
        this.to = to;
        this.reply = reply;
    }

    public String getTo()            { return to; }
    public void   setTo(String to)   { this.to = to; }

    public String getReply()               { return reply; }
    public void   setReply(String reply)   { this.reply = reply; }
}
