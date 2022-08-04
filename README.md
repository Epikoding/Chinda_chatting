# 🎮 `<친다/>` : 온라인 코딩 배틀 사이트

> _화상 및 채팅으로 소통하며 실시간으로 코드를 주고 받으며 진행하는 게임! Java, Javascript, Python 지원!_

![](https://blog.kakaocdn.net/dn/ebLQLq/btrISORcNT4/QK0L0DgRrnaikMoS68Xt70/img.png)
---

# 📼 <친다/> Demo Youtube

[https://youtu.be/b6rNFH3fR3o](https://youtu.be/b6rNFH3fR3o)

---

# 🙋🏻 저희 프로젝트가 더 궁금하신가요? ⤵️

👉 [<친다/> 이용하러 가기](http://chinda.live) 👈

👉 [프론트엔드 GitHub](https://github.com/ChoiSungwoo1216/Chin_da_FE) 👈

👉 [백엔드 GitHub](https://github.com/biolkj28/AlgorithmGameProject-BE) (game-server)👈

👉 [백엔드 GitHub](https://github.com/Epikoding/Chinda_chatting.git) (chatting-server)👈

---

# 🧗🏻‍♀️ **제작 기간 & 팀원 소개**

## 📆 제작 기간

| 총기간 | 2022년 6월 24일 ~ 2022년 8월 5일 |
| --- | --- |
| 배포일 | 2022년 7월 30일 |
| 서비스 개선 | 2022년 7월 30일 ~ 2022년 8월 5일 |

## 👫🏻 **팀원소개**

| 포지션 | 이름 | 담당 | GitHub |
| --- | --- | --- | --- |
| FE🔰 | 최성우 | 웹소켓 활용 게임 진행 로직, 채팅, `WebRTC` 화상연결, `AWS S3 CloudFront`로 `HTTPS` 배포, `Axios` 연결, 음향효과 | [https://github.com/ChoiSungwoo1216](https://github.com/ChoiSungwoo1216) |
| FE | 이민석 | 시작페이지 , 소셜 로그인, 게임 내부 기능 제작, 게임 진행 로직 | [https://github.com/leeminseok22](https://github.com/leeminseok22) |
| FE | 이윤영 | 튜토리얼 및 모달, 메인페이지, 유저정보조회, 반응형, 캐릭터 애니메이션 | [https://github.com/yunyeongyee](https://github.com/yunyeongyee) |
| BE🔰 | 이정찬 | 게임 방 조회, 입장, 퇴장, 게임 진행, 랜덤 테스트 케이스 생성 기능, 컴파일러 기능 구현,CI/CD | [https://github.com/biolkj28](https://github.com/biolkj28) |
| BE | 문수찬 | Github 소셜 로그인 및 회원가입 | [https://github.com/MrEnum](https://github.com/MrEnum) |
| BE | 이동재 | 웹소켓을 활용한 채팅과 비속어 필터링 기능 구현 | [https://github.com/Epikoding](https://github.com/Epikoding) |
| Designer | 허화영 | 디자인 | [https://www.instagram.com/workoon\_\_21](https://www.instagram.com/workoon__21/) |

---

# ****🧰**** **사용 기술 및 툴**

## **🌱 Front-end 🌱**

-   React

-   Redux

-   Axios

-   Styled-components

-   SockJS

-   StompJS

-   PeerJS

## **🌱 Back-end 🌱**

-   MySQL

-   JDoodle API

-   Stomp

-   Nginx

-   Redis

-   Selenium

-   QueryDSL

-   Spring security

-   JWT

-   Jenkins

## **🌱** 배포 **🌱**

-   Amazon S3

-   Amazon Route 53

-   Amazon CloudFront

---

# 🛠️  서비스 아키텍쳐

[![](https://blog.kakaocdn.net/dn/bvTokQ/btrIT82DDAI/D4vzozLXhOcNT3KCq243j1/img.png)](https://blog.kakaocdn.net/dn/bvTokQ/btrIT82DDAI/D4vzozLXhOcNT3KCq243j1/img.png)

---

# 🔧 **기술적 의사결정**

## 🌝 Back-end

| 사용 기술 | 기술 설명 |
| --- | --- |
| MySQL | 오픈 소스 대비 빠른 처리 속도, 표준 SQL 형식을 사용, 안정적이며 기능 개발 및 오류 발생시 많은 기업들이 사용하여 자료가 풍부함. |
| JDoodle API | 각 언어에 맞는 컴파일러 및 인터프리터를 구현 하기 위해 graal.js, nashorn,jython등 많은 라이브러리의 사용과 관리의 러닝 커브를 줄이기 위해 사용. |
| Stomp | 웹 소켓 서브 프로토콜로서 메시지 포맷이 자유롭고, 여러 브로커 사용 가능, Controller 처럼 사용하여 관리가 용이하여 사용, 게임이 실시간으로 진행 되며 상대의 코드를 확인하고, 양방향 통신의 이점을 이용해 메시지에 대한 내용을 처리 하기 위해 사용. |
| Nginx | 동시 커넥션 양 최소 10배 증가와 동일한 커넥션일 때 아파치에 비해 2배 향상, 인증서를 적용하여 https 적용을 위해 사용. |
| Redis | 이벤트 브로커 및 캐시 처리를 위해 사용(정적 데이터). |
| Selenium | 정적인 요소만 스크래핑 할 수 있는 Jsop과는 다르게 정적 인 요소 및 동적인 요소를 스크래핑 할 수 있어 사용. |
| QueryDSL | 쿼리를 가시적으로 정확하게 작성할 수 있고, 컴파일 단계에서 오류를 확인 할 수 있으며, JPA와 연계하여 사용할 수 있어 사용. |
| spring security | 많은 보안 기능을 제공과 설정의 관리가 상대적으로 용이하며 관련 자료가 많아 사용. |
| JWT | 웹 소켓 사용으로 인한 비용이 많이 발생하여 서버에 부담이 덜한 보안 방식인 토큰 방식을 채택. |
| Jenkins | 깃허브의 커밋을 확인 가능하며, 깃 허브 푸시가 됐을 때 웹 훅을 이용해, ssh로 연결된 서버로 프로젝트를 자동화 배포할 수 있어 사용. |

---

# ****✨**** 핵심기능

🚀 웹 소켓을 사용한 실시간 1 vs 1 코딩 게임 진행.

🛰 화상 및 실시간 채팅 구현.

💥 애니메이션 효과와 음향 효과.

💾 코드 에디터를 이용한 Java, JavaScript, Python 언어 사용 가능.

🧑🏻‍🚀 각 문제 조건에 부합하는 Test Case 생성을 통한 컴파일 정확도 검사.

🔭 채팅 욕설 필터링.

---

# 🔥 **Trouble shooting**

## 🌝 Back-end

### 🏷 입장과 준비 시 동시성 문제 발생

> 🏷 입장과 준비 시 동시성 문제 발생 해결.
> 
> > **📬 문제:** 1) 동시 입장 요청 시 방에 생성자 외 참여자가 여러 명 들어가는 문제 발생. 2) 동시 준비 시 각 사용자가 준비가 되었는지 확인하고 방장 에게 시작 버튼 활성화를 위 한 메시지가 전달되지 않는 문제 발생.
> 
> > **📭 해결:**
> > 
> > 1) Redis `Watch명령어`를 사용하여 `Optimistic Locking` 적용, 중복되어 들어오는 요청 시 하나의 요청을 처리하고, 다른 요청에게 정원 초과 메시지 전송.
> > 
> > 2) Thread safe 한 `ConcurrentHashMap`을 사용, `putIfAbsent`를 이용해서 해당 방의 준비 객체의 value가 null 이 아니면 둘 다 준비 된 것으로 판단, 시작 메시지 전송.

### 🏷 버퍼 사이즈 부족 문제 발생

> **🏷** 버퍼 사이즈 부족 문제 발생
> 
> > **📬 문제:** 웹 소켓 연결 후 처리 버퍼 사이즈 부족으로 Broken pipe Exception 발생되는 오류 발생.
> 
> > **📭 해결:**
> > 
> > 기존 웹 소켓은 `configureWebSocketTransport`에 버퍼 사이즈를 지정하면 되지만, Stomp를 사용하여 `DelegatingIntroductionInterceptor` 를 상속 받은 클래스를 만들어 메시지 사이즈 기본 설정 \*2 로 변경, 배포 명령어 `-Xms1024M -Xmx1024M` 를 사용해 Tomcat heap 메모리 사이즈 증가, EC2 SWAP을 통해 메모리 1GB → 4GB로 증가 시켜 해결.

### **🏷** 입장 메시지 전송 되지 않는 문제 발생

> **🏷** 입장 메시지 전송 되지 않는 문제 발생.
> 
> > **📬 문제:** `ChannelInterceptor`를 상속해 `presend`를 오버라이드하여 `subscribe` 시 구현한 입장 메시지 전송 기능 작동 안됨.
> 
> > **📭 해결:**
> > 
> > subscribe 전에 로직이 돌아 작동이 안되어 , 구독 후 작동하는`ApplicationListener<AbstractSubProtocolEvent>` 인터페이스를 상속 받아 구독 시 상대에게 본인 정보를 보내는 메시지 전송 기능을 적용하여 해결.

### 🏷 중복 로그인이 되는 문제 발생

> 🏷 중복 로그인이 되는 문제 발생.
> 
> > **📬 문제:** 중복 로그인이 되는 문제 발생.
> 
> > **📭 해결:**
> > 
> > 로그인 시 사용자 전적 정보를 Redis에 담아두고 로그인 시 해당 데이터가 있을 경우 로그아웃 처리 메시지 전달 및 레디스에서 해당 데이터 삭제 후 로그아웃 처리.

### **🏷 비속어와 필터**

> **🏷 비속어와 필터**
> 
> 📢
> 
> **‘****토끼****'**가 비속어라 가정
> 
> > **📬 문제:** 창의적인(?) 한글 비속어가 제대로 필터가 되지 않음.
> 
> > **✏️ 실현 가능한 문제해결 방안:**
> > 
> > 1.  나올 수 있는 모든 비속어를 리스트 화. ex) ‘토1끼’, ‘토끼2’, ‘ㅌㅗ끼’, ‘ㅌㅗㄲ1’ … → 너무 많은 변수로 인해 기각.
> > 
> > 2.  외부 API를 사용해 필터링을 진행. → 외부 API의 부재 및 api request & response로 실시간 채팅의 의미 저하. 기각.
> > 
> > 3.  단어 유사도 알고리즘을 사용하여 입력된 단어와 비속어를 비교 및 필터링. 채택.
> 
> > **🧮 해결:**
> > 
> > 1.  Levenshtein Distance Algorithm(편집거리 알고리즘; 이후 LDA)을 사용.
> > 
> > 2.  LDA를 기반으로 욕설 필터 제작.
> 
> > **📭 예시:**
> > 
> > 1.  입력된 단어를 LDA 필터를 통과하고 상관계수rrr값이 ≥ 0.5이면 2차 LDA 필터링 진행. ex) ‘토끼'가 비속어 임으로 ‘토성', 토지', ‘장끼'등의rrr값이 0.5.
> > 
> > 2.  입력된 단어의 각 문자를 초성, 중성, 종성으로 분해, 해당 단어를 비속어 리스트와 비교 후 유의확률p−valuep-valuep−value가 ≥ 0.66이면 비속어로 판정 및 필터링 진행.
> >     
> >     -   ex) 입력된 단어 토성과 기존 비속어 리스트에 있는 단어 토끼를 각각 ‘ㅌㅗㅅㅓㅇ’과 ‘ㅌㅗㄲㅣ’로 분해. 두 단어의 유사도가 !≥ 0.66으로 비속어 처리X.
> >     
> >     -   ex2) 입력된 단어 토1끼와 기존 비속어 리스트에 있는 단어 토끼를 각각 ‘ㅌㅗ1ㄲㅣ'와 ‘ㅌㅗㄲㅣ’로 분해. 두 단어의 유사도가 ≥ 0.66으로 비속어 처리.

---

# ⚙️ ERD

## **MySQL**

[![](https://blog.kakaocdn.net/dn/kUcoo/btrIWNRfudo/5apnSqFJx5EM63jrzPM90k/img.png)](https://blog.kakaocdn.net/dn/kUcoo/btrIWNRfudo/5apnSqFJx5EM63jrzPM90k/img.png)

---

# 📥 FLOW-CHART

## 채팅서버

[![](https://blog.kakaocdn.net/dn/bhWaQV/btrIVh58Czn/XjMjEqNua7ylkPevKVkmEk/img.png)](https://blog.kakaocdn.net/dn/bhWaQV/btrIVh58Czn/XjMjEqNua7ylkPevKVkmEk/img.png)

## 게임서버

### **로그인**

[![](https://blog.kakaocdn.net/dn/LTsLA/btrIXPA2tPe/wW0d2bkwEXeEqbglZpKR4K/img.png)](https://blog.kakaocdn.net/dn/LTsLA/btrIXPA2tPe/wW0d2bkwEXeEqbglZpKR4K/img.png)

### **인증 및 인가**

[![](https://blog.kakaocdn.net/dn/bt4dYz/btrIWMx3yRB/xWbr47Zi2j6eJd7UaVIN71/img.png)](https://blog.kakaocdn.net/dn/bt4dYz/btrIWMx3yRB/xWbr47Zi2j6eJd7UaVIN71/img.png)

### **방 생성**

[![](https://blog.kakaocdn.net/dn/eg7xRN/btrITqoUpVj/5lAu3hswdyNRNjzoSVNxgK/img.png)](https://blog.kakaocdn.net/dn/eg7xRN/btrITqoUpVj/5lAu3hswdyNRNjzoSVNxgK/img.png)

### **방 입장**

[![](https://blog.kakaocdn.net/dn/bCCpI6/btrIT82DDFE/06hVion4BcIjJxiDJWWJ8k/img.png)](https://blog.kakaocdn.net/dn/bCCpI6/btrIT82DDFE/06hVion4BcIjJxiDJWWJ8k/img.png)

### **준비**

[![](https://blog.kakaocdn.net/dn/bmrZdR/btrIYnEiSbc/LUyvCN4MhifF0mUOh5FC11/img.png)](https://blog.kakaocdn.net/dn/bmrZdR/btrIYnEiSbc/LUyvCN4MhifF0mUOh5FC11/img.png)

### **게임 진행**

[![](https://blog.kakaocdn.net/dn/HDhye/btrIWNqckGC/gRi7KpjXWC268leFJ2qc9K/img.png)](https://blog.kakaocdn.net/dn/HDhye/btrIWNqckGC/gRi7KpjXWC268leFJ2qc9K/img.png)

### **방 퇴장**

[![](https://blog.kakaocdn.net/dn/dDxSFX/btrISO4HTRe/DzOG3rGdEEqkv6sE8ctXMK/img.png)](https://blog.kakaocdn.net/dn/dDxSFX/btrISO4HTRe/DzOG3rGdEEqkv6sE8ctXMK/img.png)

### **컴파일러 동작**

[![](https://blog.kakaocdn.net/dn/RCkVa/btrIWMSmJlp/ylFTptzbck8dcuysP62EHk/img.png)](https://blog.kakaocdn.net/dn/RCkVa/btrIWMSmJlp/ylFTptzbck8dcuysP62EHk/img.png)

---

# 🎤  **마케팅 전략**

## 🏷 항해 99 내 약 2천명의 개발자에게 홍보

> 🏷 독창적인 사이트로 많은 이목이 집중
> 
> > **📬 전략**: 1\. 개발자가 즐길 수 있는 사이트인 만큼, 많은 개발자가 모여있는 곳에서 홍보하고 재치있는 문구로 이목을 집중받는 전략을 사용 2. 기프티콘을 통해 설문조사 참여에 동기를 부여하여 다양한 유저 피드백을 받기 위해 투자
> 
> > **📭 결과 :**
> > 
> > 사이트 개설, 홍보와 동시에 동접 3자리 수가 넘어가며 구두와 설문조사로 다양한 피드백을 수렴하였음
> 
> > **🧮 홍보 자료:**
> > 
> > [![](https://blog.kakaocdn.net/dn/N6Tsh/btrIRGFMuB9/cV4Vzcy7Hu1KVMN5atSgkk/img.png)](https://blog.kakaocdn.net/dn/N6Tsh/btrIRGFMuB9/cV4Vzcy7Hu1KVMN5atSgkk/img.png)

## 🏷 즉각 피드백 반영

> 🏷 유저의 피드백을 소중히 생각해, 패치를 통해 의견을 반영
> 
> > **📬 전략**: 공통된 유저들의 의견을 모아서, 빠르게 반영하는 것으로 신뢰를 주고, 유저와 소통하고 있는 느낌을 부여
> 
> > **📭 결과 :**
> > 
> > 패치 이후, 해당 문제에 관련해서는 문제를 제기하지 않고, 만족도가 상승하였음.
> 
> > **🧮 홍보 자료:**
> > 
> > [![](https://blog.kakaocdn.net/dn/6cxTA/btrIToLpUOq/gxogRCas9hK8NxMTnoKcu1/img.png)](https://blog.kakaocdn.net/dn/6cxTA/btrIToLpUOq/gxogRCas9hK8NxMTnoKcu1/img.png)

## 🏷 게임을 재미있게 즐기기 위한 대회

> 🏷 참가자가 저조하여 행사를 진행하지 못함
> 
> > **📬 분석**:
> > 
> > 1.  홍보가 부족하였음. 전체가 모인 채팅방에 공지만 올리고 실제로 돌아다니면서 참가자를 모으는 것을 고려하지 못함.
> > 
> > 2.  대상자들의 상황을 고려하지 못함. 타겟 대상자들인 7기 C반 동료들의 최종 마감 기간이 다가올수록 생각보다 여유가 더 없었던 것을 고려하지 못하였음.
> > 
> > 3.  홍보 시간이 잘못되었음. 사람들이 Slack을 가장 많이 볼, 아침이나, 점심에 홍보를 했어야 하지만, 새벽에 하는 것으로 관심을 받지 못함.
> 
> > **📭 배운 점 :**
> > 
> > 1.  타겟층에 대해서 더 정밀한 분석이 필요
> > 
> > 2.  홍보 문구가 전부가 아닌, 홍보 시기, 즉 타이밍이 중요하다는 것을 느낌
> > 
> > 3.  하나의 수단으로 홍보하는 것이 아닌 다양한 방식으로 타겟층에 접근해야 홍보효과가 나타나는 것을 알게됨
> 
> > **🧮 홍보 자료:**
> > 
> > [![](https://blog.kakaocdn.net/dn/bRy0cz/btrIWMSmJnE/rk2kmYmSFs2ksWEm0Adkqk/img.png)](https://blog.kakaocdn.net/dn/bRy0cz/btrIWMSmJnE/rk2kmYmSFs2ksWEm0Adkqk/img.png)

---

# 🧑🏻‍🔧  **피드백 개선**

## 🏷 배경음 및 효과음 볼륨 조절

> 🏷 배경음 및 효과음 볼륨 조절
> 
> > **📬 피드백**: 볼륨 조절이 필요할 것 같다. Mute 기능 추가 요청
> 
> > **📭 기능 개선 :**
> > 
> > 배경음 및 효과음 볼륨을 on/off가 아닌 클릭으로 조절
> 
> > **🧮 Before :**
> > 
> > [![](https://blog.kakaocdn.net/dn/bYKgTz/btrIVglQlnN/n96I41kKRjhl6cKgImLurk/img.png)](https://blog.kakaocdn.net/dn/bYKgTz/btrIVglQlnN/n96I41kKRjhl6cKgImLurk/img.png)
> 
> > **🧮 After :**
> > 
> > [![](https://blog.kakaocdn.net/dn/1DQUt/btrITpXRgLn/XGdb9rJGZw9DLGBE3SYB91/img.png)](https://blog.kakaocdn.net/dn/1DQUt/btrITpXRgLn/XGdb9rJGZw9DLGBE3SYB91/img.png)

## **🏷 시작 버튼 추가**

> **🏷 시작 버튼 추가**
> 
> > **📬 피드백**: 스타트 버튼이 따로 있다면 어디 있는지 잘 보이지 않는다. 입장 후 상대방과 레디를 했음에도 시작이 안되었다. 만약 시작을 할 수 있는 버튼 등이 따로 있다면 조금 더 분명하게 나타나도 좋을 것 같다는 의견
> 
> > **📭 기능 개선 :**
> > 
> > eady만 누르고 양쪽이 다 누르면 자동으로 시작되었던 기존의 방식에서 상대방이 레디를 눌렀는지 확인 할 수 있게 변경하였고 방장이 게임을 시작할 수 있게 버튼을 추가
> 
> > **🧮 Before :**
> > 
> > [![](https://blog.kakaocdn.net/dn/dUxqgv/btrIXwaCWFK/YJTdcZeeoek8g8Kg9eVIV1/img.png)](https://blog.kakaocdn.net/dn/dUxqgv/btrIXwaCWFK/YJTdcZeeoek8g8Kg9eVIV1/img.png)
> 
> > **🧮 After :**
> > 
> > [![](https://blog.kakaocdn.net/dn/dRTzcG/btrIT8BDIvQ/yh8QEjEkcF6sqjDkmlElZk/img.png)](https://blog.kakaocdn.net/dn/dRTzcG/btrIT8BDIvQ/yh8QEjEkcF6sqjDkmlElZk/img.png)

## 🏷 튜토리얼이 자동으로 보여지는 기능 추가

> 🏷 튜토리얼이 자동으로 보여지는 기능 추가
> 
> > **📬 피드백**: 뒤로 가기 버튼이나 따로 설명이 없어서 뒤로 갈 때 사용하기가 어렵다. 이것저것 눌러보다가 언어 누르니까 뒤로 가게 되었다며 서비스에 대한 이해 부족으로 이탈율이 높아지는 것에 대해 개선
> 
> > **📭 기능 개선:** 초기 사용자에게 튜토리얼이 자동으로 보여지는 기능 추가
> 
> > **🧮 참고자료:**
> > 
> > [![](https://blog.kakaocdn.net/dn/bOWJyu/btrIUalRetE/B3vC5sgCso5P5ZKXvrX2G1/img.png)](https://blog.kakaocdn.net/dn/bOWJyu/btrIUalRetE/B3vC5sgCso5P5ZKXvrX2G1/img.png)

## **🏷 정원초과 알림**

> **🏷 정원초과 알림**
> 
> > **📬 피드백**: 인원이 찬 방에 입장이 가능하다며 개선 요청
> 
> > **📭 기능 개선:** 정원초과 알림 기능 추가
> 
> > **🧮 참고자료:**
> > 
> > [![](https://blog.kakaocdn.net/dn/besTJX/btrIRG6URmO/9ebMSyGQnC5NT2pd2i03Nk/img.jpg)](https://blog.kakaocdn.net/dn/besTJX/btrIRG6URmO/9ebMSyGQnC5NT2pd2i03Nk/img.jpg)

---

# ✍🏻 7**조 한 줄 회고**

> <덜 외로운 공간> “고3 때 수능 공부하는 것 만큼 힘들지 않아요?” ”무슨소리예요. 그 때는 이렇게까지 힘들지 않았어요. 지금이 그 때보다 훨씬 더 힘들죠” 항해99를 같이하는 반 사람에게 위의 질문을 할 때 마다 돌아왔던 비슷한 맥락의 대화. 열심히 공부해서 대학진학을 준비했던 고3 때도, 자격증 시험을 준비했던 때도 그 어떤 때와 비교를 해도 지금이 가장 힘들다고. 아마 삶이라는 무게가 어깨위로 얹혀졌기 때문일 것이라 나는 이내 생각했다. 정말로 다사다난 한 3개월이었다. 항해99를 시작한지 얼마 안 된 직후 개발자가 될 수 있을거라는 희망이 절망으로 바뀌기까지 오랜 시간이 걸리지 않았다. 그리고 그렇게 “과연 내가 개발자를 할 수 있을까?”란 의문을 품은채 실전 프로젝트를 시작했다. 그렇다. 나도 그들처럼 가장 힘든 시간을 보내고 있었다. 지금 프로젝트를 끝내고 한 줄 회고를 쓰고있는 상황에서 과거를 돌이켜보니 그 때의 대화들이 의미심장하다. 정말 힘들었던 그 순간들과 그만두고 싶은 매 순간들이 아이러니하게도 나를 일으켜 세우는 원동력이 되었기 때문이다. 나와 함께하는 팀원들과, 같은 Spring을 공부하는 동료들 모두 같은 감정을 느끼고 있었다. 우리는 외로움, 힘듬, 지침 등 정신적 그리고 신체적 고통을 공유하며 서로를 위로했다. 괜찮다고, 조금만 버티면 된다고 그렇게 서로 버팀목이 되어 목적지도 모르는 그 어딘가로 향했다. 신체적으로 닿아있지는 않지만 같이 공부하는 이들과 같이 희비애락을 나누며 우리는 서로 유대감을 느꼈다. 그로 인해 게더는 덜 외로운 공간이 되었다. 고마움을 표현할 이들은 일일이 나열할 수 없다. 지난 6주 동안 나와 함께한 7기 C반 7조 동료들, 서로를 의지한체 공부했던 Spring 사람들, 좋은 글과 참고자료를 남겨주었던 수 많은 블로거들과 유튜버들, 그들이 없었다면 나는 아마 무사히 프로젝트를 끝내지 못했을 것이다. 나와 같은 길을 걷는 모든이가 어디를 가든 무엇을 하든 평안하고 복되길 바란다고 이 자리를 빌려 감사의 말을 전해본다. _\- 이동재_

> 신생아 발걸음 _\- 문수찬_

> 프로젝트를 시작할 때, 남들과 같이 배운 것을 최종 프로젝트로 하는 것보다, 차별성있게, 배운 것을 독창성있는 아이디어로 표현하는 것을 목표 삼았습니다. 남들과 다른 방식의 프로젝트이다보니, 이를 성공적으로 이끌기 위해서 필요한게 무엇일지 많이 생각하였습니다. 1번은 소통이고, 2번은 계획이라는 생각이 들었습니다. 저를 포함해 모두가 미경험자로 새로운 것을 도전하는 것에 두려움을 가슴에 품고 작업을 진행하게 될 것을 알고 있었습니다. 그렇기에 업무적인 소통만 오가는 프로젝트는 결국 사소한 의견 차이에도 감정이 쉽게 상하고 엇나갈 수 있기에, 이를 조율하고 서로를 동료라고 인식하게 하는 역할이 프론트의 조장으로써 필요하다고 생각하였습니다. 1주차에 주제가 선정되면서 머리 속에 어떤 로직을 사용할지, 언제까지 구상을 할지 계획을 세워보고 시작하였습니다. 다만 아쉬운 점은 이를 문서화해 더 명확하게 해두었으면 좋았을 것 같습니다. 계획이 수립되고 Due Date이 정해지니, 업무 분담이 효율적으로 이루어 졌고, 오히려 계획을 유동적으로 변경할 수 있어서, 마감 기간 안에 잘 마무리 한 것 같습니다. 프로젝트 기간 6주동안, 팀장으로써, 개발자로써 정말 값진 경험을 하였습니다. 팀원과 소통하는 법, 서로의 코드를 통해 발전하는 것, 새로운 지식을 공부하는 법, 매일 매일이 트러블 슈팅의 연속이었고 이를 양분으로써 성장할 수 있었습니다. Open Mind… 가장 중요한 키워드인 것 같습니다. 다양한 가능성에 문을 열어놓고, 나와 다른 의견을 인정할 줄 알고, 이를 토대로 성장하는 것. 서론이 길었네요… 저의 한 줄 회고 ”피라미드는 진짜 사람이 만들었고, <친다/>는 우리가 만들었다.“ _\- 최성우_

> 하나의 프로그램을 목표로 두고 "혼자"가 아닌 "서로" 의지하며 밤을 새우고, 버티고, 문제를 찾아가는 과정을 통해 개발은 혼자 하는 것이 아닌 함께 하는 것이라는 것을 절실하게 느낄 수 있는 시간이었고, 프론트 분들의 노력을 보며, 개인적으로도 백엔드 팀으로서도 더 효율적이고, 더 빠르게 결괏값을 드릴 수 있도록 노력하기 위해 공부하면서 많은 트러블 슈팅을 겪고 성장하며, 동기부여를 받을 수 있었던, 팀이라는 의미를 다시 생각해 볼 수 있었던 시간이었습니다. 긴 기간 동안, 다들 너무 고생 많으셨습니다!! _\- 이정찬_

> 6주간 즐거웠고, 재미있게 했습니다! 다들 고생하셨습니다! “이게 되네” _\- 이민석_

---

  

Uploaded by

[N2T](https://github.com/jmjeon94/N2T)
