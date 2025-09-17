package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Implementation of the {@link ChatService}.
 * This class handles the logic of forwarding a chat request to the Python ML service.
 */
@Service
public class ChatServiceImpl implements ChatService {

    private final WebClient webClient;

    /**
     * Constructs the service and initializes the WebClient for communicating with the Python API.
     * @param webClientBuilder The Spring-managed WebClient.Builder.
     */
    @Autowired
    public ChatServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000").build();
    }

    /**
     * {@inheritDoc}
     * <p>
     * This implementation sends the user's message to the Python ML service's /predict endpoint
     * and returns the response asynchronously.
     */
    @Override
    public Mono<ChatResponse> chat(ChatRequest request) {
        // Call the Python ML API and return the Mono
        return webClient.post()
                .uri("/predict")
                .body(Mono.just(request), ChatRequest.class)
                .retrieve()
                .bodyToMono(ChatResponse.class)
                .onErrorResume(e -> {
                    // Log the error and return a fallback response
                    System.err.println("Error calling Python API: " + e.getMessage());
                    return Mono.just(new ChatResponse("Sorry, I'm having trouble connecting to my brain right now."));
                });
    }
}
