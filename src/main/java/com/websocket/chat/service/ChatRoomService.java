package com.websocket.chat.service;

import com.websocket.chat.model.ChatRoom;
import com.websocket.chat.pubsub.RedisSubscriber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private static final String CHAT_ROOMS = "CHAT_ROOM"; // Redis
    private static final String USER_COUNT = "USER_COUNT"; // Redis
    private static final String ENTER_INFO = "ENTER_INFO"; // Redis

    private final RedisSubscriber redisSubscriber; // 구독 처리 서비스
    private final RedisTemplate<String, Object> redisTemplate;
    private final RedisMessageListenerContainer redisMessageListener; // 채팅방(topic)에 발행되는 메시지를 처리할 Listener
    private static final ConcurrentMap<String, ChannelTopic> topics = new ConcurrentHashMap<>(); // 채팅방의 대화 메시지를 발행하기 위한 redis topic 정보. 서버별로 채팅방에 매치되는 topic정보를 Map에 넣어 roomId로 찾을수 있도록 한다.
    private HashOperations<String, String, Object> opsHashChatRoom; // 채팅방에 CHAT_ROOMS, chatRoom.getRoomId(), chatRoom를 넣음.


    @PostConstruct
    public void init(){
        opsHashChatRoom = redisTemplate.opsForHash();
    }

    /**
     * 채팅방 생성 : 서버간 채팅방 공유를 위해 redis hash에 저장한다.
     */
    public ChatRoom createChatRoom(String name) {
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(UUID.randomUUID().toString())
                .name(name)
                .build();

        opsHashChatRoom.put(CHAT_ROOMS, chatRoom.getRoomId(), chatRoom);

        log.info("chatRoomId = " + chatRoom.getRoomId());

        return chatRoom;
    }

    /**
     * 채팅방 입장 : redis에 topic을 만들고 pub/sub 통신을 하기 위해 리스너를 설정한다.
     */
    public void enterChatRoom(String roomId) {
        log.info("방입장: {}" , roomId);

        ChannelTopic topic = topics.get(roomId);

        if (topic == null)
            topic = new ChannelTopic(roomId);

        redisMessageListener.addMessageListener(redisSubscriber, topic);
        topics.put(roomId, topic);
    }

    public ChannelTopic getTopic(String roomId) {
        return topics.get(roomId);
    }

}
