package com.websocket.chat.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ChatRoomInfoService {
    private static final String USER_COUNT = "USER_COUNT"; // Redis
    private static final String ENTER_INFO = "ENTER_INFO"; // Redis
    private final RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, String> opsHashEnterInfo; // 채팅방에 유저 조회
    private ValueOperations<String, Object> opsFinder;

    @PostConstruct
    public void init() {
        opsHashEnterInfo = redisTemplate.opsForHash();
        opsFinder = redisTemplate.opsForValue();
    }

    /**
     * 유저가 입장한 채팅방id와 유저 세션id 맵핑 정보 저장
     * @param sessionId: 유저 세션id
     * @param roomId : 채팅방id
     */
    public void setUserEnterInfo(String sessionId, String roomId) {
        log.info(sessionId);
        log.info(roomId);

        opsHashEnterInfo.put(ENTER_INFO, sessionId, roomId);

        log.info(String.valueOf(opsHashEnterInfo));
    }

    /**
     * 유저 세션id로 입장해 있는 채팅방id 조회
     * @param sessionId: 유저 세션id
     */
    public String getUserEnterRoomId(String sessionId) {
        return opsHashEnterInfo.get(ENTER_INFO, sessionId);
    }

    /**
     * 유저 세션id와 맵핑된 채팅방id 삭제
     * @param sessionId: 유저 세션id
     */
    public void removeUserEnterInfo(String sessionId) {
        opsHashEnterInfo.delete(ENTER_INFO, sessionId);
    }

    /**
     * 채팅방 유저수 조회
     * @param roomId: 채팅방id
     * @return: 해당 방에 몇명이 있는지 조회하고 아무도 없다면 0
     */
    public long getUserCount(String roomId) {
        return Long.parseLong((String) Optional.ofNullable(opsFinder.get(USER_COUNT + "_" + roomId)).orElse("0"));
    }

    /**
     * 채팅방에 입장한 유저수 +1
     * @param roomId: 채팅방id
     * @return: 해당 채팅방에 숫자 1을 더하지만 해당 방이 없다면 0
     */
    public long plusUserCount(String roomId) {
        log.info(String.valueOf(opsFinder));
        return Optional.ofNullable(opsFinder.increment(USER_COUNT + "_" + roomId)).orElse(0L);
    }

    /**
     * 채팅방에 입장한 유저수 -1
     * @param roomId: 채팅방id
     * @return: 해당 채팅방에 숫자가 0을 초과하면 1을 빼지만 해당 방이 없다면 0
     */
    public long minusUserCount(String roomId) {
        return Optional.ofNullable(opsFinder.decrement(USER_COUNT + "_" + roomId)).filter(count -> count > 0).orElse(0L);
    }

    /**
     * destination정보에서 roomId 추출
     * @param destination
     * @return
     */
    public String getRoomId(String destination) {
        int lastIndex = destination.lastIndexOf('/');

        if (lastIndex != -1)
            return destination.substring(lastIndex + 1);
        else
            return "";
    }
}
