package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Override
    public ChatResponse chat(ChatRequest request) {
        // Placeholder logic: Echo the message.
        // In the future, this will call the Python ML model.
        String replyMessage = "Received message: " + request.getMessage();
        return new ChatResponse(replyMessage);
    }
}
