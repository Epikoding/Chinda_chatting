package com.websocket.chat.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CurseWordFilter {
//    private final CurseWordList curseWordList;
//    private final RedisTemplate<String, List<String>> redisTemplate;

    public int getLevenshteinDistance(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0 : 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }

        return T[m][n];
    }

    public String findSimilarity(String inputWord) throws IOException {
        List<String> filteredCursedWord = new ArrayList<>();
        List<String> curseWordList = new ArrayList<>();

        File file = new File("fword_list.txt"); //파일 객체 생성
        FileReader filereader = new FileReader(file); //입력 스트림 생성
        BufferedReader bufReader = new BufferedReader(filereader); //입력 버퍼 생성
        String line = "";
        while ((line = bufReader.readLine()) != null) { // readLine()은 끝에 개행문자를 읽지 않는다.
            curseWordList.add(line);
        }
        bufReader.close();

//        ObjectMapper mapper = new ObjectMapper();
//        List<String> jsonInString = Collections.singletonList(mapper.writeValueAsString(curseWordList));
//        redisTemplate.opsForValue().set("욕설리스트", jsonInString);

        if (inputWord == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        double maxLength = inputWord.length();
        double result = 0;
        List<Double> resultList = new ArrayList<>();

        for (String curseWord : curseWordList) {
            if (maxLength > 0) {
                // 필요한 경우 선택적으로 대소문자를 무시합니다.
                result = (maxLength - getLevenshteinDistance(inputWord, curseWord)) / maxLength;
                resultList.add(result);
            }
        }
        double maxNum = resultList.get(0);
        for (double j : resultList) {
            if (j > maxNum)
                maxNum = j;
        }

        System.out.println("Maximum number = " + maxNum);

        if (maxNum > 0.66) {
            for (int i = 0; i < inputWord.length(); i++) {
                filteredCursedWord.add("*");
            }
        } else {
            return inputWord;
        }

        StringBuilder filtered = new StringBuilder();
        for (String string : filteredCursedWord) {
            filtered.append(string);
        }

        return String.valueOf(filtered);
    }

//    private void fwordListToRedisTempl(List<String> curseWordList) throws IOException {
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
//    }


}

