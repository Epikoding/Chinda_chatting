package com.websocket.chat.config;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.web.socket.WebSocketSession;

// messagebroker가 처리할 수 있는 램 용량 증가
public class SubProtocolWebSocketHandlerInterceptor extends DelegatingIntroductionInterceptor {
    @Override
    protected Object doProceed(MethodInvocation mi) throws Throwable {
        if (mi.getMethod().getName().equals("afterConnectionEstablished")){
            WebSocketSession session = (WebSocketSession) mi.getArguments()[0];
            session.setTextMessageSizeLimit(64*1024*2); //128kb
        }
        return super.doProceed(mi);
    }
}
