package com.websocket.chat.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSockConfig implements WebSocketMessageBrokerConfigurer {
    private final StompHandler stompHandler;
    private final AgentWebSocketHandlerDecoratorFactory decoratorFactory;

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setDecoratorFactories(decoratorFactory)
                .setTimeToFirstMessage(30 * 60 * 10000) // 10000 = 1초
                .setSendTimeLimit(30 * 60 * 10000); // 30분 설정

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/sub");
        config.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-stomp")
                .setHandshakeHandler(new UserHandshakeHandler())
                .setAllowedOriginPatterns("*")
                .setAllowedOrigins("epikoding.shop")
                .setAllowedOrigins("www.epikoding.shop")
                .setAllowedOrigins("localhost:3000")
                .setAllowedOrigins("chinda.live")
                .setAllowedOrigins("www.chinda.live")
                .withSockJS();
    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(stompHandler);
    }


}

