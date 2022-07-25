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
     * 유저가 입장한 채팅방ID와 유저 세션ID 맵핑 정보 저장
     * @param sessionId
     * @param roomId
     */
    public void setUserEnterInfo(String sessionId, String roomId) {
        log.info(sessionId);
        log.info(roomId);

        opsHashEnterInfo.put(ENTER_INFO, sessionId, roomId);

        log.info(String.valueOf(opsHashEnterInfo));
    }

    /**
     * 유저 세션으로 입장해 있는 채팅방 ID 조회
     * @param sessionId
     * @return
     */
    public String getUserEnterRoomId(String sessionId) {
        return opsHashEnterInfo.get(ENTER_INFO, sessionId);
    }

    /**
     * 유저 세션정보와 맵핑된 채팅방ID 삭제
     * @param sessionId
     */
    public void removeUserEnterInfo(String sessionId) {
        opsHashEnterInfo.delete(ENTER_INFO, sessionId);
    }

    /**
     * 채팅방 유저수 조회
     * @param roomId
     * @return
     */
    public long getUserCount(String roomId) {
//    public long getUserCount(String sessionId, String roomId) {
//        opsHashEnterInfo.get(ROOM_NUM_STATE, sessionId, roomId);
        return Long.parseLong((String) Optional.ofNullable(opsFinder.get(USER_COUNT + "_" + roomId)).orElse("0"));
    }

    /**
     * 채팅방에 입장한 유저수 +1
     * @param roomId
     * @return
     */
    public long plusUserCount(String roomId) {
//    public long plusUserCount(String sessionId, String roomId) {
        log.info(String.valueOf(opsFinder));
//        opsHashEnterInfo.put(ROOM_NUM_STATE, sessionId, roomId);
        return Optional.ofNullable(opsFinder.increment(USER_COUNT + "_" + roomId)).orElse(0L);
    }

    /**
     * 채팅방에 입장한 유저수 -1
     * @param roomId
     * @return
     */
    public long minusUserCount(String roomId) {
//    public long minusUserCount(String sessionId, String roomId) {
//        opsHashEnterInfo.delete(ROOM_NUM_STATE, sessionId, roomId);
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
