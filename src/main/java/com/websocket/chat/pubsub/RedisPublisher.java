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

    /**
     * CurseWordFilter를 통해서 온 메시지를 redistemplate으로 발행
     * @param topic: 세션id
     * @param message: CurseWordFilter를 통해서 온 메시지ows IOException
     */
    public void publish(ChannelTopic topic, ChatMessage message) throws IOException {
        message.setMessage(curseWordFilter.advancedFindSimilarity(message.getMessage()));
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}