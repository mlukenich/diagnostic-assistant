package com.medical.chatbot.dto;

/**
 * Represents a request from a user to the chat service.
 */
public class ChatRequest {

    /**
     * The user's message content.
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
