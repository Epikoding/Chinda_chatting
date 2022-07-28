package com.websocket.chat.filter;

import com.websocket.chat.repo.CurseWordRepository;
import com.websocket.chat.service.WordDisassembleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class CurseWordFilter {
    private final WordDisassembleService wordDisassembleService;
    private final CurseWordRepository curseWordRepository;
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

        File file = new File("fword_list.txt"); // 파일 객체 생성
        FileReader filereader = new FileReader(file); // 입력 스트림 생성
        BufferedReader bufReader = new BufferedReader(filereader); // 입력 버퍼 생성
        String line = "";
        while ((line = bufReader.readLine()) != null) { // readLine()은 끝에 개행문자를 읽지 않는다.
            curseWordList.add(line);
        }
        bufReader.close(); // 비속어 불러오기 끝

        if (inputWord == null) {
            throw new IllegalArgumentException("채팅방에 메시지를 적어주세요.");
        }

        double maxLength = inputWord.length();
        double result = 0;
        List<Double> resultList = new ArrayList<>();

        for (String curseWord : curseWordList) {
            if (maxLength > 0) {

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

    public String advancedFindSimilarity(String message) throws IOException {
        List<String> curseWordList = curseWordRepository.readCurseWords();

        if (message == "") {
            throw new IllegalArgumentException("채팅창에 아무것도 안 치고 엔터쳤음.");
        }

        List<String> messageArray = Arrays.asList(message.split(" ")); // 띄어쓰기를 기준으로 분리된 메세지가 담기는 list
        Map<Double, String> allCurseWordsValues = new HashMap<>(); // {비속어 매칭률}, {fword_list의 비속어} map
        List<String> messageToList = new ArrayList<>(); // message가 필터링되어 담길 list

        double potentialRate = 0; // 비속어일 확률 초기값
        for (String eachWord : messageArray) {
            String[] curseWord = new String[eachWord.length()]; // 띄어쓰기를 기준으로 분할된 단어의 길이
            if (eachWord.length() > 0) {
                for (int i = 0; i < curseWordList.size(); i++) {
                    potentialRate = (double) (eachWord.length() - getLevenshteinDistance(eachWord, curseWordList.get(i))) / eachWord.length();
                    allCurseWordsValues.put(potentialRate, curseWordList.get(i));
                }

                Double maxNum = Collections.max(allCurseWordsValues.keySet()); //potentialRate가 가장 높은 값
                log.info("{}이 비속어일 1차 확률 {}", eachWord, maxNum);

                if (maxNum >= 0.5) { // 귀무가설(H_0) 기각역 a < 0.5. 비속어일 가능성이 절반 이상이면
                    String maxValue = allCurseWordsValues.get(maxNum); // maxNum의 값의 value

                    String decomposedMaxValue = wordDisassembleService.decompose(maxValue); // 초성 중성 종성으로 분해
                    String decomposedInputWord = wordDisassembleService.decompose(eachWord); // 초성 중성 종성으로 분해

                    int maxNumBetween = Math.max(decomposedMaxValue.length(), decomposedInputWord.length()); // 분해된 단어의 가장 긴 값
                    int minNumBetween = Math.min(decomposedMaxValue.length(), decomposedInputWord.length()); // 분해된 단어의 가장 짧은 값

                    potentialRate = getLevenshteinDistance(decomposedInputWord, decomposedMaxValue); // 분해된 단어들로 욕설인지 구체적으로 비교
                    double gapBetween = (double) 1 - (potentialRate / maxNumBetween); // 1-b. 검정력(power of test)
                    log.info("{}이 비속어일 2차 확률 {}", eachWord, gapBetween);

                    if (gapBetween >= 0.66) { // 비속어로 판명나면
                        for (int i = 0; i < eachWord.length(); i++) {
                            curseWord[i] = "*"; // 단어를 별표로 바꿈
                        }
                        StringBuilder filteredWord = new StringBuilder();
                        for (String string : curseWord) {
                            filteredWord.append(string);
                        }
                        messageToList.add(String.valueOf(filteredWord)); // 비속어를 새롭게 만들어진 문장 리스트에 넣어주고

                    } else {
                        return eachWord; // 비속어가 아닌거라면 메시지에서 분할된 단어 가져오고
                    }
                } else {
                    messageToList.add(eachWord); // 비속어가 아닌 단어를 문장 리스트에 넣어줌
                }
                allCurseWordsValues.clear(); // 한 단어의 비속어 map 초기화
            }
        }

        StringBuilder filtered = new StringBuilder();
        for (String string : messageToList) {
            filtered.append(string).append(" "); // 단어를 넣어주면서 원래 문장 크기로 복원
        }

        return filtered.toString();
    }
}

