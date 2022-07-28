package com.websocket.chat.repo;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CurseWordRepository {
    final List<String> curseWordList = new ArrayList<>(); // fword_list가 담길 list

    public List<String> readCurseWords() throws IOException {
        File file = new File("fword_list.txt"); // 비속어.txt 불러오기
        FileReader filereader = new FileReader(file); // 입력 스트림 생성
        BufferedReader bufReader = new BufferedReader(filereader); // 입력 버퍼 생성

        String line = "";
        while ((line = bufReader.readLine()) != null) { // readLine()은 끝에 개행문자를 읽지 않음
            curseWordList.add(line);
        }
        bufReader.close();
        return curseWordList;
    }
}