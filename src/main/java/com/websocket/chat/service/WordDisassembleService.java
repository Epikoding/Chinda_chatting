package com.websocket.chat.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

@Slf4j
@Service
public class WordDisassembleService {
    final static String[] chosung_list =
            {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    final static String[] jungsung_list =
            {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};
    final static String[] jongsung_list =
            {"", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    final static String[] jaum_list =
            {"ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄸ", "ㄹ", "ㄺ", "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅃ", "ㅄ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
    final static String[] moum_list =
            {"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ"};
    final static String[] specialChar = {"!","@","#","$","%","^","&","*","(",")",",",".","?","{","}","|","<",">","[","]","\\", "'", "\"", " "};
    char chosung_base = 588;
    char jungsung_base = 28;
    char kor_begin = 44032; //가
    char kor_end = 55203; //힣
    char jaum_begin = 12593; //ㄱ
    char jaum_end = 12622; //ㅎ
    char moum_begin = 12623; //ㅏ
    char moum_end = 12643; //ㅣ

//    void test() {
//        System.out.println("kor_begin = " + kor_begin);
//        System.out.println("kor_end = " + kor_end);
//        System.out.println("chosung_base = " + chosung_base);
//        System.out.println("jungsung_base = " + jungsung_base);
//        System.out.println("jaum_begin = " + jaum_begin);
//        System.out.println("jaum_end = " + jaum_end);
//        System.out.println("moum_begin = " + moum_begin);
//        System.out.println("moum_end = " + moum_end);
//    }

    /**
     * 초성, 중성, 종성을 받아와 한 단어로 만듬.
     */
    public char compose(String chosung, String jungsung, String jongsung) {
        char oneWord;
        oneWord =
                (char) (kor_begin +
                        chosung_base * Arrays.binarySearch(chosung_list, chosung) +
                        jungsung_base * Arrays.binarySearch(jungsung_list, jungsung) +
                        Arrays.binarySearch(jongsung_list, jongsung));
        System.out.println(oneWord);
        return oneWord;
    }

    /**
     * 한 단어를 초성, 중성, 종성으로 분해.
     * @param text: 띄어쓰기를 기준으로 분해된 한 단어.
     * @return: 한 단어의 문자를 기준으로 리스트로 반환.
     * https://needjarvis.tistory.com/644 참고
     */
    public String decompose(String text) {
        ArrayList<String> decomposedWordList = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char uniVal = text.charAt(i);

            // 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행
            if (uniVal >= 0xAC00) { // 초성, '가'
                uniVal = (char) (uniVal - 0xAC00);

                char cho = (char) (uniVal / 28 / 21); // 초성
                char joong = (char) ((uniVal) / 28 % 21); // 중성
                char jong = (char) (uniVal % 28);    // 종성의 첫번째는 채움이기 때문에

                decomposedWordList.add(chosung_list[cho] + jungsung_list[joong] + jongsung_list[jong]);

            } else if (0x3131 <= uniVal || uniVal <= 0x314e) { // 'ㅋ', 'ㅅㄱ'와 같은 자음은 분리하는 과정을 거치지 않음
                decomposedWordList.add(String.valueOf(uniVal));

            } else if ((uniVal>=0x21 && uniVal<=0x2f) // '!', '?' 와 같은 특수문자 예외처리
                    || (uniVal>=0x3a && uniVal<=0x40)
                    || (uniVal>=0x5b && uniVal<=0x60)
                    || (uniVal>=0x7b && uniVal<=0x7e)){
                decomposedWordList.add(String.valueOf(uniVal));

            } else {
                log.info(uniVal + " => " + uniVal);
            }
        }

        String decomposedWord = String.join("", decomposedWordList);
        log.info("decomposedWordList = {}", decomposedWordList);

        return decomposedWord;
    }
}

