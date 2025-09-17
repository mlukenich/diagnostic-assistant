package com.medical.chatbot.controller;

import com.medical.chatbot.dto.ChatRequest;
import com.medical.chatbot.dto.ChatResponse;
import com.medical.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * REST controller for handling chat-related requests.
 * Exposes an endpoint for users to interact with the chatbot.
 */
@RestController
@RequestMapping("/api/v1")
public class ChatController {

    private final ChatService chatService;

    /**
     * Constructs the controller with a dependency on the ChatService.
     * @param chatService The service that handles chat logic.
     */
    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    /**
     * Handles a user's chat message.
     *
     * @param request The chat request containing the user's message.
     * @return A {@link Mono} that emits the {@link ChatResponse} from the service.
     */
    @PostMapping("/chat")
    public Mono<ChatResponse> chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }
}
