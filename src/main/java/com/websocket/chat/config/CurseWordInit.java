package com.websocket.chat.config;

import com.websocket.chat.repo.CurseWordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurseWordInit implements ApplicationRunner {
    private final CurseWordRepository curseWordRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        curseWordRepository.saveCurseWords();
    }
}
