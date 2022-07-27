package com.websocket.chat.controller;

import com.websocket.chat.model.ChatMessage;
import com.websocket.chat.model.MessageType;
import com.websocket.chat.pubsub.RedisPublisher;
import com.websocket.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller // 방으로 들어오는 유저의 메시지 처리 컨트롤러
@RequiredArgsConstructor
public class ChatController {
    private final RedisPublisher redisPublisher;
    private final ChatRoomService chatRoomService;

    /**
     * websocket, /pub/chat/message으로 들어오는 메시징을 처리
     *
     * @param message
     */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) throws IOException {
        MessageType values = message.getType();
        switch (values) {
            case ENTER:
                chatRoomService.enterChatRoom(message.getRoomId());
                message.setMessage(message.getSender() + "님이 입장하셨습니다.");
                redisPublisher.publish(chatRoomService.getTopic(message.getRoomId()), message);
                break;

            case TALK:
                redisPublisher.publish(chatRoomService.getTopic(message.getRoomId()), message);
                break;

            case EXIT:
                message.setMessage(message.getSender() + "님이 퇴장하셨습니다.");
                redisPublisher.publish(chatRoomService.getTopic(message.getRoomId()), message);
                break;

        }
    }
}
