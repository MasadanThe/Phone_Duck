package com.example.phone_duck.configuration;

import com.example.phone_duck.webSocket.SocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketChannelConfiguration implements WebSocketConfigurer {
    @Autowired
    private SocketHandler socketHandler;

    private final static String SOCKET_PREFIX = "/sub";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(socketHandler, SOCKET_PREFIX + "/channels");
        registry.addHandler(socketHandler, SOCKET_PREFIX + "/chat/");
    }
}
