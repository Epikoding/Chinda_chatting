package com.websocket.chat.config;

import com.websocket.chat.service.ChatRoomInfoService;
import com.websocket.chat.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class StompHandler implements ChannelInterceptor {
    private final ChatRoomInfoService chatRoomInfoService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT == accessor.getCommand()) { // websocket 연결요청
            log.info("CONNECT accessor = " + accessor);

        } else if (StompCommand.SUBSCRIBE == accessor.getCommand()) { // websocket 구독 요청
            log.info("SUBSCRIBE accessor = " + accessor);

            String sessionId = (String) message.getHeaders().get("simpSessionId");
            String roomId = chatRoomInfoService.getRoomId(Optional.ofNullable(
                    (String) message.getHeaders().get("simpDestination")).orElse("InvalidRoomId"));

            chatRoomInfoService.plusUserCount(roomId); // 채팅방의 인원수 +1
            chatRoomInfoService.setUserEnterInfo(sessionId, roomId);

            long userCount = chatRoomInfoService.getUserCount(roomId); // 특정 방의 인원 수 확인

            if (userCount > 2) {
                throw new IllegalStateException("정원초과");
            } else if (userCount < 0) {
                userCount = 0;
            }

            log.info("방 인원 수: {}", String.valueOf(chatRoomInfoService.getUserCount(roomId))); // 채팅방의 인원수 표시
            log.info("SUBSCRIBED sessionId: {}, roomId: {}", sessionId, roomId);

        } else if (StompCommand.DISCONNECT == accessor.getCommand()) { // Websocket 연결 종료
            log.info("DISCONNECT accessor = " + accessor);

            String sessionId = (String) message.getHeaders().get("simpSessionId");
            String roomId = chatRoomInfoService.getUserEnterRoomId(sessionId); //sessionId로 roomId 가져오기

            chatRoomInfoService.removeUserEnterInfo(sessionId);
            chatRoomInfoService.minusUserCount(roomId); // 채팅방의 인원수 -1

            log.info("방 인원 수: {}", String.valueOf(chatRoomInfoService.getUserCount(roomId))); // 채팅방의 인원수 표시
            log.info("DISCONNECTED sessionId: {}, roomId: {}", sessionId, roomId);
        }
        return message;
    }

    // TODO: 2022/07/25 다른 메소드 사용할 수 있는 게 있을까?
}