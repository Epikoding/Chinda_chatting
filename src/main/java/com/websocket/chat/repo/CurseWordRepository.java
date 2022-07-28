package com.websocket.chat.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CurseWordRepository {
    private final RedisTemplate<String, String> redisTemplate; // 캐스팅이 되기에 String, Object를 할 필요가 없음
    final List<String> curseWordList = new ArrayList<>(); // fword_list가 담길 list

    public void saveCurseWords() throws IOException {
        File file = new File("fword_list.txt"); // 비속어.txt 불러오기
        FileReader filereader = new FileReader(file); // 입력 스트림 생성
        BufferedReader bufReader = new BufferedReader(filereader); // 입력 버퍼 생성

        String line = "";
        while ((line = bufReader.readLine()) != null) { // readLine()은 끝에 개행문자를 읽지 않음
            curseWordList.add(line);
        }
        bufReader.close();
        redisTemplate.opsForList().rightPushAll("fword_list", curseWordList);
    }

    public List<String> readCurseWords() {
        long fwordListEnd = redisTemplate.opsForList().size("fword_list") - 1;
        List<String> fword_list = redisTemplate.opsForList().range("fword_list", 0, fwordListEnd);

        return fword_list;
    }
}