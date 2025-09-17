package com.medical.chatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for setting up the WebClient.
 * This class provides a centralized place for WebClient configuration.
 */
@Configuration
public class WebClientConfig {

    /**
     * Provides a singleton bean of {@link WebClient.Builder}.
     * This builder can be injected into other components to create customized WebClient instances.
     *
     * @return A pre-configured WebClient.Builder instance.
     */
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
}
