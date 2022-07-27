//package com.websocket.chat.model;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Component
//public class CurseWordList {
//    private RedisTemplate<String, List<String>> redisTemplate;
//    private static final List<String> curseWordList = new ArrayList<>();
//
//    public RedisTemplate<String, List<String>> CurseWordList() throws IOException {
//        File file = new File("fword_list.txt"); //파일 객체 생성
//        FileReader filereader = new FileReader(file); //입력 스트림 생성
//        BufferedReader bufReader = new BufferedReader(filereader); //입력 버퍼 생성
//        String line = "";
//        while ((line = bufReader.readLine()) != null) { // readLine()은 끝에 개행문자를 읽지 않는다.
//            curseWordList.add(line);
//        }
//        bufReader.close();
//
//        ObjectMapper mapper = new ObjectMapper();
//        List<String> jsonInString = Collections.singletonList(mapper.writeValueAsString(curseWordList));
//        redisTemplate.opsForValue().set("욕설리스트", jsonInString);
//        return redisTemplate;
//    }
//}
