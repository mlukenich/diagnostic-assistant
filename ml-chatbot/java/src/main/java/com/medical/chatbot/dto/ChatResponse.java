package com.medical.chatbot.dto;

/**
 * Represents a response from the chat service to a user.
 */
public class ChatResponse {

    /**
     * The service's reply message.
     */
    private String reply;

    /**
     * Constructs a new ChatResponse.
     * @param reply The reply message.
     */
    public ChatResponse(String reply) {
        this.reply = reply;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
