package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import reactor.core.publisher.Mono;

public interface ChatService {
    Mono<ChatResponse> chat(ChatRequest request);
}
