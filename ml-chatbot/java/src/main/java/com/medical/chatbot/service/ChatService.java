package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;

public interface ChatService {
    ChatResponse chat(ChatRequest request);
}
