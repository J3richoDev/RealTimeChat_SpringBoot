package com.chat.realtime.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;;

@Configuration
@EnableWebSocketMessageBroker
public interface WebSocketConfig extends WebSocketMessageBrokerConfigurer{
    
    @Override
    default void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
            .setAllowedOrigins("*")
            .withSockJS();
    }

    @Override
    default void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
