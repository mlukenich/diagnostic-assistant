package com.medical.chatbot.service;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class ChatServiceImpl implements ChatService {

    private final WebClient webClient;

    @Autowired
    public ChatServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8000").build();
    }

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
