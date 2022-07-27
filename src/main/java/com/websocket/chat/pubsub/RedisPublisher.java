package com.websocket.chat.pubsub;

import com.websocket.chat.filter.CurseWordFilter;
import com.websocket.chat.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final CurseWordFilter curseWordFilter;

    public void publish(ChannelTopic topic, ChatMessage message) throws IOException {
        message.setMessage(curseWordFilter.findSimilarity(message.getMessage()));
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}