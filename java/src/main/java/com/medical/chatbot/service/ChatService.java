package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import reactor.core.publisher.Mono;

/**
 * Defines the contract for the chat service.
 * The service is responsible for handling the business logic of the chat interaction.
 */
public interface ChatService {

    /**
     * Processes a user's chat request and returns a response.
     *
     * @param request The user's chat request, containing the message.
     * @return A {@link Mono} that emits the chat response.
     */
    Mono<ChatResponse> chat(ChatRequest request);
}
